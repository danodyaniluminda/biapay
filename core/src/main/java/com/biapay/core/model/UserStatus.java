package com.biapay.core.model;

public enum UserStatus {
  LOCKED,
  SUSPICIOUS_LOGIN,
  PASSWORD_EXPIRED,
  ACCOUNT_EXPIRED,
  ACTIVE,
  APPROVED,
  INACTIVE,
  DEACTIVATED,
  // with this status, a user will never be able to connect anymore
  SUSPENDED,
  TESTING
}
