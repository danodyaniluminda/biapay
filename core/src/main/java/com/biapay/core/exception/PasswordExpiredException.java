package com.biapay.core.exception;


import org.springframework.security.authentication.AuthenticationServiceException;

public class PasswordExpiredException extends AuthenticationServiceException {

    public PasswordExpiredException(String message) {
        super(message);
    }


}
