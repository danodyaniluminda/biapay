package com.biapay.core.util;

import com.biapay.core.constant.BIAConstants.Auth;
import com.biapay.core.dto.LoggedInUserDTO;
import com.biapay.core.exception.BIAPayRuntimeException;
import com.biapay.core.exception.NotFoundException;
import com.biapay.core.model.Merchant;
import com.biapay.core.model.MerchantSubUser;
import com.biapay.core.model.User;
import com.biapay.core.model.UserType;
import com.biapay.core.repository.MerchantSubUserRepository;
import com.biapay.core.repository.UserRepository;
import java.util.Arrays;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.KeycloakPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import static com.biapay.core.model.UserType.*;

@Component
@Slf4j
public class AuthUtil {
  private static final PathMatcher pathMatcher = new AntPathMatcher();
  private static UserRepository userRepository;
  private static MerchantSubUserRepository merchantSubUserRepository;

  @Autowired
  public AuthUtil(
      UserRepository userRepository, MerchantSubUserRepository merchantSubUserRepository) {
    AuthUtil.userRepository = userRepository;
    AuthUtil.merchantSubUserRepository = merchantSubUserRepository;
  }

  public static LoggedInUserDTO getLoggedInUser() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (!(authentication instanceof AnonymousAuthenticationToken)) {
      // Get the Keycloak principal from the authentication object
      KeycloakPrincipal<?> keycloakPrincipal = (KeycloakPrincipal<?>) authentication.getPrincipal();
      UserType userType = getUserType(keycloakPrincipal);

      // We need to replace only the first prefix as we have emails such as admin_maker@biapay.net.
      // Keycloak is configured with admin_admin_maker@biapay.net thus we remove only first admin_
      String email = keycloakPrincipal.getKeycloakSecurityContext().getToken().getPreferredUsername().replaceFirst("(?i)" + userType + "_", "");
      log.info("getLoggedInUser email {} and userType {}", email, userType);
      User user = userRepository.findByEmailAndUserType(email, userType);
      if (user == null) {
        throw new BIAPayRuntimeException("User not found");
      }
      LoggedInUserDTO principal = LoggedInUserDTO.builder()
              .userId(user.getUserId())
              .userType(userType)
              .sub(keycloakPrincipal.getKeycloakSecurityContext().getToken().getSubject())
              .email(user.getEmail())
              .user(user)
              .build();
      if (principal.getUserType().equals(UserType.SUB_MERCHANT)) {
        log.info("Logged in user is a sub merchant user...");
        MerchantSubUser merchantSubUser =
            merchantSubUserRepository.findBySubUser_UserId(principal.getUserId());
        if (merchantSubUser != null) {
          log.info(
              "Found. User: {} is impersonating merchant user: {}",
              merchantSubUser.getSubUser().getUserId(),
              merchantSubUser.getMerchantUser().getUserId());
          User merchantUser = merchantSubUser.getMerchantUser();
          principal.setImpersonator(
              LoggedInUserDTO.builder()
                  .userId(principal.getUserId())
                  .userType(principal.getUserType())
                  .email(principal.getEmail())
                      .user(principal.getUser())
                  .build());
          principal.setUserId(merchantUser.getUserId());
          principal.setUserType(MERCHANT);
          principal.setEmail(merchantUser.getEmail());
          principal.setUser(merchantUser);
          return principal;
        }
      }
      return principal;
    }
    throw new AuthenticationServiceException("Unauthenticated user");
  }

  private static UserType getUserType(KeycloakPrincipal<?> keycloakPrincipal) {
    UserType userType = UserType.USER;
    if (keycloakPrincipal.getKeycloakSecurityContext().getToken().getPreferredUsername().startsWith(UserType.ADMIN.toString().toLowerCase() +"_")){
      userType = UserType.ADMIN;
    }else if (keycloakPrincipal.getKeycloakSecurityContext().getToken().getPreferredUsername().startsWith(UserType.MERCHANT_SHOP_MANAGER.toString().toLowerCase() +"_")){
      userType = UserType.MERCHANT_SHOP_MANAGER;
    }else if (keycloakPrincipal.getKeycloakSecurityContext().getToken().getPreferredUsername().startsWith(UserType.MERCHANT_POS_MANAGER.toString().toLowerCase() +"_")){
      userType = UserType.MERCHANT_POS_MANAGER;
    }else if (keycloakPrincipal.getKeycloakSecurityContext().getToken().getPreferredUsername().startsWith(UserType.MERCHANT_POS.toString().toLowerCase() +"_")){
      userType = UserType.MERCHANT_POS;
    }else if (keycloakPrincipal.getKeycloakSecurityContext().getToken().getPreferredUsername().startsWith(UserType.SUB_MERCHANT.toString().toLowerCase() +"_")){
      userType = UserType.SUB_MERCHANT;
    }else if (keycloakPrincipal.getKeycloakSecurityContext().getToken().getPreferredUsername().startsWith(UserType.MERCHANT.toString().toLowerCase() +"_")){
      userType = UserType.MERCHANT;
    }
    return userType;
  }

  public User getLoggedInUserInfo() {
    return getLoggedInUser().getUser();
  }

  public static boolean isAuthorizationNotRequired(String path) {
    return Arrays.stream(Auth.PUBLIC_URLS)
        .anyMatch(
            s -> {
              if (pathMatcher.match(path, s)) {
                return true;
              } else {
                return false;
              }
            });
  }

  public Merchant getLoggedInUserMerchant() {
    LoggedInUserDTO loggedInUser = getLoggedInUser();
    return getLoggedInUserMerchant(loggedInUser);
  }

  public Merchant getLoggedInUserMerchant(LoggedInUserDTO loggedInUser) {
    if (loggedInUser.getUserType() == MERCHANT) {
      return loggedInUser.getUser().getMerchant();
    } else if (loggedInUser.getUserType() == MERCHANT_SHOP_MANAGER) {
      return loggedInUser.getUser()
              .getMerchantShops().stream()
              .findFirst()
              .orElseThrow(() -> new NotFoundException("No shop exists"))
              .getMerchant();
    } else if (loggedInUser.getUserType() == MERCHANT_POS_MANAGER) {
      return loggedInUser.getUser()
              .getMerchantPOSs().stream()
              .findFirst()
              .orElseThrow(() -> new NotFoundException("No pos exists"))
              .getShop()
              .getMerchant();
    } else {
      return null;
    }
  }

  public User getUser() {
    return getLoggedInUser().getUser();
  }
}
