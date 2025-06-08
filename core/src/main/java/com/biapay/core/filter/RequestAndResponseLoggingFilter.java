package com.biapay.core.filter;

import com.biapay.core.helper.ServiceIdContainer;
import com.biapay.core.helper.ServiceIdGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@ManagedResource
@Slf4j
public class RequestAndResponseLoggingFilter extends OncePerRequestFilter {
    @Autowired
    private ServiceIdGenerator serviceIdGenerator;

    private static final List<MediaType> VISIBLE_TYPES = Arrays.asList(
            MediaType.valueOf("text/*"),
            MediaType.APPLICATION_FORM_URLENCODED,
            MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML,
            MediaType.valueOf("application/*+json"),
            MediaType.valueOf("application/*+xml"),
            MediaType.MULTIPART_FORM_DATA
    );

    /**
     * List of HTTP headers whose values should not be logged.
     */
    private static final List<String> SENSITIVE_HEADERS = Arrays.asList(
            "authorization",
            "proxy-authorization"
    );

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (isAsyncDispatch(request)) {
            filterChain.doFilter(request, response);
        } else {
            doFilterWrapped(wrapRequest(request), wrapResponse(response), filterChain);
        }
    }

    protected void doFilterWrapped(ContentCachingRequestWrapper request, ContentCachingResponseWrapper response, FilterChain filterChain) throws ServletException, IOException {
        ServiceIdContainer.setServiceId(serviceIdGenerator.generateUniqueId());
        try {
            beforeRequest(request, response);
            filterChain.doFilter(request, response);
        } finally {
            response.addHeader("X-Request-ID", ServiceIdContainer.getServiceId());
            afterRequest(request, response);
            response.copyBodyToResponse();

            ServiceIdContainer.clearServiceId();
        }
    }

    protected void beforeRequest(ContentCachingRequestWrapper request, ContentCachingResponseWrapper response) {
        log.info("-- REQUEST for " + ServiceIdContainer.getServiceId() + " --");
        logRequestHeader(request,"");
    }

    protected void afterRequest(ContentCachingRequestWrapper request, ContentCachingResponseWrapper response) {
        logRequestBody(request, "");
        log.info("-- RESPONSE for " + ServiceIdContainer.getServiceId() + " --");
        logResponse(response, "");
    }

    private static void logRequestHeader(ContentCachingRequestWrapper request, String prefix) {
        String queryString = request.getQueryString();
        if (queryString == null) {
            log.info(String.format("%s %s %s", prefix, request.getMethod(), request.getRequestURI()));
        } else {
            log.info(String.format("%s %s %s?%s", prefix, request.getMethod(), request.getRequestURI(), queryString));
        }
        log.info(String.format("%s Request IP: %s", prefix, getIpAddress(request)));

        HashMap<String, String> headers = new HashMap<>();

        Collections.list(request.getHeaderNames())
                .forEach(headerName ->
                        Collections.list(request.getHeaders(headerName))
                                .forEach(headerValue -> {
                                    if (isSensitiveHeader(headerName)) {
                                        headers.put(headerName, "*******");
                                    } else {
                                        headers.put(headerName, headerValue);
                                    }
                                }));

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            log.info(String.format("%s Request Headers: %s", prefix, objectMapper.writeValueAsString(headers)));
        } catch (Exception ex) {
            log.error(String.format("%s Error: %s", prefix, "Failed to parse request headers!"));
        }

    }

    private static void logRequestBody(ContentCachingRequestWrapper request, String prefix) {
        byte[] content = request.getContentAsByteArray();
        if (content.length > 0) {
            logContent(content, request.getContentType(), request.getCharacterEncoding(), prefix, "REQUEST");
        }
    }

    private static void logResponse(ContentCachingResponseWrapper response, String prefix) {
        int status = response.getStatus();
        log.info(String.format("%s %s %s", prefix, status, HttpStatus.valueOf(status).getReasonPhrase()));

        HashMap<String, String> headers = new HashMap<>();
        response.getHeaderNames()
                .forEach(headerName ->
                        response.getHeaders(headerName)
                                .forEach(headerValue ->
                                {
                                    if (isSensitiveHeader(headerName)) {
                                        headers.put(headerName, "*******");
                                    } else {
                                        headers.put(headerName, headerValue);
                                    }
                                }));
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            log.info(String.format("%s Response Headers: %s", prefix, objectMapper.writeValueAsString(headers)));
        } catch (Exception ex) {
            log.error(String.format("%s Error: %s", prefix, "Failed to parse response headers!"));
        }

        byte[] content = response.getContentAsByteArray();
        if (content.length > 0) {
            logContent(content, response.getContentType(), response.getCharacterEncoding(), prefix, "RESPONSE");
        }
    }

    private static void logContent(byte[] content, String contentType, String contentEncoding, String prefix, String logFor) {
        MediaType mediaType = MediaType.valueOf(contentType);
        boolean visible = VISIBLE_TYPES.stream().anyMatch(visibleType -> visibleType.includes(mediaType));
        if (visible) {
            try {
                String contentString = new String(content, contentEncoding);

                if (logFor.equalsIgnoreCase("REQUEST")) {
                    log.info(String.format("%s Request Payload: %s", prefix, contentString));
                } else if (logFor.equalsIgnoreCase("RESPONSE")) {
                    log.info(String.format("%s Response Payload: %s", prefix, contentString));
                }
            } catch (UnsupportedEncodingException e) {
                log.info(String.format("%s [%d bytes content]", prefix, content.length));
            }
        } else {
            log.info(String.format("%s [%d bytes content]", prefix, content.length));
        }
    }

    private static String getIpAddress(ContentCachingRequestWrapper request){
        // Try to get the client IP address from the X-Forwarded-For header, which may contain a comma-separated list of IPs
        String ipAddress = request.getHeader("X-Forwarded-For");

        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            // If X-Forwarded-For is not present, fallback to the actual remote IP
            ipAddress = request.getRemoteAddr();
        }

        // If there is a comma-separated list, use the first IP in the list
        if (ipAddress != null && ipAddress.contains(",")) {
            ipAddress = ipAddress.split(",")[0].trim();
        }

        return ipAddress;
    }

    /**
     * Determine if a given header name should have its value logged.
     *
     * @param headerName HTTP header name.
     * @return True if the header is sensitive (i.e. its value should <b>not</b> be logged).
     */
    private static boolean isSensitiveHeader(String headerName) {
        return SENSITIVE_HEADERS.contains(headerName.toLowerCase());
    }

    private static ContentCachingRequestWrapper wrapRequest(HttpServletRequest request) {
        if (request instanceof ContentCachingRequestWrapper) {
            return (ContentCachingRequestWrapper) request;
        } else {
            return new ContentCachingRequestWrapper(request);
        }
    }

    private static ContentCachingResponseWrapper wrapResponse(HttpServletResponse response) {
        if (response instanceof ContentCachingResponseWrapper) {
            return (ContentCachingResponseWrapper) response;
        } else {
            return new ContentCachingResponseWrapper(response);
        }
    }
}
