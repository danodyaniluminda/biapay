package com.biapay.core.filter;

import static com.biapay.core.constant.BIAConstants.Auth.*;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.biapay.core.dto.LoggedInUserDTO;
import com.biapay.core.model.UserType;
import com.biapay.core.util.AuthUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Slf4j
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
  public static final String TOKEN_PREFIX = "Bearer ";
  public static final String HEADER_STRING = "Authorization";

  private String jwtSecret;

  public JWTAuthorizationFilter(AuthenticationManager authenticationManager, String jwtSecret) {
    super(authenticationManager);
    this.jwtSecret = jwtSecret;
  }

  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    if (AuthUtil.isAuthorizationNotRequired(request.getRequestURI())) {
      chain.doFilter(request, response);
    } else {
      String header = request.getHeader(HEADER_STRING);

      if (header == null || !header.startsWith(TOKEN_PREFIX)) {
        response.sendError(HttpStatus.FORBIDDEN.value(), "Token not present or invalid header");
        return;
      }

      try {
        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
      } catch (JWTVerificationException e) {
        log.warn("Jwt verification failed: {}", e.getMessage());
        response.sendError(HttpStatus.FORBIDDEN.value(), e.getMessage());
        return;
      }
    }
  }

  // Reads the JWT from the Authorization header, and then uses JWT to validate the token
  private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
    String token = request.getHeader(HEADER_STRING);

    if (token != null) {
      // parse the token.
      DecodedJWT decodedJWT =
          JWT.require(Algorithm.HMAC512(jwtSecret.getBytes()))
              .build()
              .verify(token.replace(TOKEN_PREFIX, ""));
      String email = decodedJWT.getClaim(JWT_EMAIL).asString();
      List<String> roles = decodedJWT.getClaim(JWT_ROLES).asList(String.class);
      List<String> permissions = decodedJWT.getClaim(JWT_PERMISSIONS).asList(String.class);
      UserType userType = UserType.valueOf(decodedJWT.getClaim(JWT_USERTYPE).asString());
      Long userId = decodedJWT.getClaim(JWT_ID).asLong();
      List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
      grantedAuthorities.addAll(
          roles.stream().map(s -> new SimpleGrantedAuthority(s)).collect(Collectors.toList()));
      grantedAuthorities.addAll(
          permissions.stream()
              .map(s -> new SimpleGrantedAuthority(s))
              .collect(Collectors.toList()));

      LoggedInUserDTO loggedInUserDTO =
          LoggedInUserDTO.builder()
              .sub(decodedJWT.getSubject())
              .email(email)
              .userType(userType)
              .userId(userId)
              .build();
      return new UsernamePasswordAuthenticationToken(loggedInUserDTO, null, grantedAuthorities);
    }

    return null;
  }
}
