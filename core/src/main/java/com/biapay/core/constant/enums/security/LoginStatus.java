package com.biapay.core.constant.enums.security;

public enum LoginStatus {
  Success {
    @Override
    public String toString() {
      return "Success";
    }
  },
  UserNotFound {
    @Override
    public String toString() {
      return "User Not Found";
    }
  },
  UserLocked {
    @Override
    public String toString() {
      return "User Locked";
    }
  },
  UserInactive {
    @Override
    public String toString() {
      return "User Inactive";
    }
  },
  InvalidCredential {
    @Override
    public String toString() {
      return "Invalid Credential";
    }
  },
  EmptyUser {
    @Override
    public String toString() {
      return "Empty User";
    }
  },
  EmptyPassword {
    @Override
    public String toString() {
      return "Empty Password";
    }
  },
  InvalidCredentialNextAttemptWillLockUser {
    @Override
    public String toString() {
      return "Invalid Credential, Next Attempt Will Lock User";
    }
  },
  InactivityPeriodExceeded {
    @Override
    public String toString() {
      return "Inactivity Period Exceeded";
    }
  },
  InvalidProcessCredential {
    @Override
    public String toString() {
      return "Invalid Process Credential";
    }
  },
}
