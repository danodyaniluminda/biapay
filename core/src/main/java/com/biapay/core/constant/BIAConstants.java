package com.biapay.core.constant;

public class BIAConstants {
  public static class Auth {
    public static final String JWT_ROLES = "roles";
    public static final String JWT_GROUPS = "groups";
    public static final String JWT_ID = "id";
    public static final String JWT_PROFILE_INFO = "profileInfo";
    public static final String JWT_PERMISSIONS = "permissions";
    public static final String JWT_EMAIL = "email";
    public static final String JWT_USERTYPE = "userType";
    public static final String LOGIN_URL = "/auth/login";
    public static final String[] PUBLIC_URLS = {
        "/auth/login",
        "/auth/recovery/email",
        "/auth/recovery/questions",
        "/auth/recovery/otp",
        "/auth/recovery/confirm",
        "/user/registration",
        "/merchant/registration",
        "/auth/confirmation/email",
        "/auth/verification/email",
        "/settings",
        "/user/registered",
        "/api/sms",
        "/common/settings",
        "/admin/security/questions/public",
        "/auth/recovery",
        "/auth/suspiciousLogin",
        "/merchant/verification/phone/sendOTP",
        "/merchant/verification/phone/verifyOTP",
        "/api/mfa/generate",
        "/api/mfa/validate",
        "/user/pay-link/view",
        "/user/pay-link/public",
        "/invoice/public/u",
        "/api/mfa/public/otp",
        "/api/mfa/methods",
        "/api/mfa/public/otp/resend",
        "/user/pay-link/public/updatePaymentAmount",
    };
  }

  public static class Email {
    public static final String USER_REGISTRATION_EMAIL_CONFIRMATION =
        "USER_REGISTRATION_EMAIL_CONFIRMATION";
    public static final String MERCHANT_REGISTRATION_EMAIL_CONFIRMATION =
        "MERCHANT_REGISTRATION_EMAIL_CONFIRMATION";
    public static final String FORGOT_PASSWORD_URL_EMAIL = "FORGOT_PASSWORD_URL_EMAIL";
    public static final String RESET_PASSWORD_EMAIL_CONFIRMATION =
        "RESET_PASSWORD_EMAIL_CONFIRMATION";
    public static final String KYC_SUBMITTED_EMAIL = "KYC_SUBMITTED_EMAIL";
    public static final String KYC_PENDING_APPROVAL = "KYC_PENDING_APPROVAL";
    public static final String KYC_APPROVED_EMAIL = "KYC_APPROVED_EMAIL";
    public static final String KYC_REJECTED_EMAIL = "KYC_REJECTED_EMAIL";
    public static final String NEW_BROWSER_DETECTED = "NEW_BROWSER_DETECTED";
    public static final String ADMIN_USER_CREATION_EMAIL = "ADMIN_USER_CREATION_EMAIL";

    public static final String MERCHANT_REGISTER = "MERCHANT_REGISTER";

    public static final String TICKET_NOTIFICATION_INTERNAL = "TICKET_NOTIFICATION_INTERNAL";
    public static final String TICKET_NOTIFICATION_EXTERNAL = "TICKET_NOTIFICATION_EXTERNAL";

    // for KYC ALERT
    public static final String KYC_NOT_SENT_ALERT_EMAIL = "KYC_NOT_SENT_ALERT_EMAIL";
    public static final String ACCOUNT_SUSPENDED_BECAUSE_OF_KYC_MISSING_EMAIL =
        "ACCOUNT_SUSPENDED_BECAUSE_OF_KYC_MISSING_EMAIL";

    public static final String ACCOUNT_INACTIVATED_BECAUSE_OF_KYC_MISSING_EMAIL =
        "ACCOUNT_SUSPENDED_BECAUSE_OF_KYC_MISSING_EMAIL";

    public static final String CUSTOMER_PAY_LINK_NOTIFICATION = "CUSTOMER_PAY_LINK_NOTIFICATION";
    public static final String CUSTOMER_PAY_LINK_EXPIRED_NOTIFICATION =
        "CUSTOMER_PAY_LINK_EXPIRED_NOTIFICATION";

    public static final String TRANSACTION_MFA_REQUEST = "TRANSACTION_MFA_REQUEST";
    public static final String MFA_EMAIL_QR_REQUEST = "MFA_EMAIL_QR_REQUEST";

    public static final String NEW_REGISTRATION = "NEW_REGISTRATION";

    public static final String CHANGE_USER_STATUS = "CHANGE_USER_STATUS";

    public static final String SEND_OTP = "SEND_OTP";
    public static final String SETTLEMENT_SUCCESS_NOTIFICATION = "SETTLEMENT_SUCCESS_NOTIFICATION";

    public static final String MERCHANT_SUB_USER_CREATION = "MERCHANT_SUB_USER_CREATION";

    public static final String CUSTOMER_PAY_LINK_REMINDER_NOTIFICATION = "CUSTOMER_PAY_LINK_REMINDER_NOTIFICATION";

    public static final String USER_KYC_VERIFICATION = "USER_KYC_VERIFICATION";

  }

  public static class SMSTemplate {
    public static final String CUSTOMER_PHONE_VERIFY = "CUSTOMER_PHONE_VERIFY";
    public static final String MERCHANT_PHONE_VERIFY = "MERCHANT_PHONE_VERIFY";
    public static final String CUSTOMER_PAY_LINK = "CUSTOMER_PAY_LINK";

    public static final String TRANSACTION_MFA_REQUEST = "TRANSACTION_MFA_REQUEST";
    public static final String USER_MFA_ACTIVATION_WITH_QR = "USER_MFA_ACTIVATION_WITH_QR";
    public static final String MFA_SMS_OTP_REQUEST = "MFA_SMS_OTP_REQUEST";

    public static final String CUSTOMER_PAY_LINK_NOTIFICATION = "CUSTOMER_PAY_LINK_NOTIFICATION";
    public static final String CUSTOMER_PAY_LINK_REMINDER_NOTIFICATION = "CUSTOMER_PAY_LINK_REMINDER_NOTIFICATION";

    public static final String USER_KYC_VERIFICATION = "USER_KYC_VERIFICATION";
  }

  public static class SMSTemplateLocale {
    public static final String EN = "en";
    public static final String FR = "fr";
  }

  public static class Locale {
    public static final String EN = "en";
    public static final String FR = "fr";
  }

  public static class Language {
    public static final String ENGLISH = "English";
  }

  public static class Errors {
    public static final String TWO_FACTOR_AUTHENTICATION_MISSING =
        "TWO_FACTOR_AUTHENTICATION_MISSING";
    public static final String TWO_FACTOR_AUTHENTICATION_FAILED = "TWO_FACTOR_FAILED";
  }

  public static class TwoFactorMethods {
    public static final String SMS_TWO_FACTOR = "SMS_TWO_FACTOR";
    public static final String EMAIL_TWO_FACTOR = "EMAIL_TWO_FACTOR";
    public static final String AUTHENTICATOR_TWO_FACTOR = "AUTHENTICATOR_TWO_FACTOR";
    public static final String WHATSAPP_TWO_FACTOR = "WHATSAPP_TWO_FACTOR";
  }

  public class Permission {
    public static final String VIEW_USER = "VIEW_USER";
    public static final String ADD_USER = "ADD_USER";
    public static final String EDIT_USER = "EDIT_USER";
    public static final String DELETE_USER = "DELETE_USER";
    public static final String LIST_USER = "LIST_USER";
    public static final String VIEW_ADMIN_USER = "VIEW_ADMIN_USER";
    public static final String ADD_ADMIN_USER = "ADD_ADMIN_USER";
    public static final String EDIT_ADMIN_USER = "EDIT_ADMIN_USER";
    public static final String DELETE_ADMIN_USER = "DELETE_ADMIN_USER";
    public static final String LIST_ADMIN_USER = "LIST_ADMIN_USER";
    public static final String VIEW_MERCHANT = "VIEW_MERCHANT";
    public static final String ADD_MERCHANT = "ADD_MERCHANT";
    public static final String EDIT_MERCHANT = "EDIT_MERCHANT";
    public static final String DELETE_MERCHANT = "DELETE_MERCHANT";
    public static final String LIST_MERCHANT = "LIST_MERCHANT";
    public static final String VIEW_PAYMENT_METHOD = "VIEW_PAYMENT_METHOD";
    public static final String ADD_PAYMENT_METHOD = "ADD_PAYMENT_METHOD";
    public static final String EDIT_PAYMENT_METHOD = "EDIT_PAYMENT_METHOD";
    public static final String DELETE_PAYMENT_METHOD = "DELETE_PAYMENT_METHOD";
    public static final String LIST_PAYMENT_METHOD = "LIST_PAYMENT_METHOD";
    public static final String VIEW_PAYMENT_CATEGORY = "VIEW_PAYMENT_CATEGORY";
    public static final String ADD_PAYMENT_CATEGORY = "ADD_PAYMENT_CATEGORY";
    public static final String EDIT_PAYMENT_CATEGORY = "EDIT_PAYMENT_CATEGORY";
    public static final String DELETE_PAYMENT_CATEGORY = "DELETE_PAYMENT_CATEGORY";
    public static final String LIST_PAYMENT_CATEGORY = "LIST_PAYMENT_CATEGORY";
    public static final String VIEW_SETTLEMENT_ACCOUNT_CATEGORY = "VIEW_SETTLEMENT_ACCOUNT_CATEGORY";
    public static final String ADD_SETTLEMENT_ACCOUNT_CATEGORY = "ADD_SETTLEMENT_ACCOUNT_CATEGORY";
    public static final String EDIT_SETTLEMENT_ACCOUNT_CATEGORY = "EDIT_SETTLEMENT_ACCOUNT_CATEGORY";
    public static final String DELETE_SETTLEMENT_ACCOUNT_CATEGORY = "DELETE_SETTLEMENT_ACCOUNT_CATEGORY";
    public static final String LIST_SETTLEMENT_ACCOUNT_CATEGORY = "LIST_SETTLEMENT_ACCOUNT_CATEGORY";
    public static final String VIEW_CURRENCY = "VIEW_CURRENCY";
    public static final String ADD_CURRENCY = "ADD_CURRENCY";
    public static final String EDIT_CURRENCY = "EDIT_CURRENCY";
    public static final String DELETE_CURRENCY = "DELETE_CURRENCY";
    public static final String LIST_CURRENCY = "LIST_CURRENCY";
    public static final String VIEW_ROLE = "VIEW_ROLE";
    public static final String ADD_ROLE = "ADD_ROLE";
    public static final String EDIT_ROLE = "EDIT_ROLE";
    public static final String DELETE_ROLE = "DELETE_ROLE";
    public static final String LIST_ROLE = "LIST_ROLE";
    public static final String VIEW_TICKET = "VIEW_TICKET";
    public static final String ADD_TICKET = "ADD_TICKET";
    public static final String EDIT_TICKET = "EDIT_TICKET";
    public static final String DELETE_TICKET = "DELETE_TICKET";
    public static final String LIST_TICKET = "LIST_TICKET";
    public static final String VIEW_SETTING = "VIEW_SETTING";
    public static final String ADD_SETTING = "ADD_SETTING";
    public static final String EDIT_SETTING = "EDIT_SETTING";
    public static final String DELETE_SETTING = "DELETE_SETTING";
    public static final String LIST_SETTING = "LIST_SETTING";
    public static final String VIEW_SUBSCRIPTION = "VIEW_SUBSCRIPTION";
    public static final String ADD_SUBSCRIPTION = "ADD_SUBSCRIPTION";
    public static final String EDIT_SUBSCRIPTION = "EDIT_SUBSCRIPTION";
    public static final String DELETE_SUBSCRIPTION = "DELETE_SUBSCRIPTION";
    public static final String LIST_SUBSCRIPTION = "LIST_SUBSCRIPTION";
    public static final String VIEW_DOWNGRADE_REQUEST = "VIEW_DOWNGRADE_REQUEST";
    public static final String ADD_DOWNGRADE_REQUEST = "ADD_DOWNGRADE_REQUEST";
    public static final String EDIT_DOWNGRADE_REQUEST = "EDIT_DOWNGRADE_REQUEST";
    public static final String DELETE_DOWNGRADE_REQUEST = "DELETE_DOWNGRADE_REQUEST";
    public static final String LIST_DOWNGRADE_REQUEST = "LIST_DOWNGRADE_REQUEST";
    public static final String VIEW_TRANSACTION_FEE = "VIEW_TRANSACTION_FEE";
    public static final String ADD_TRANSACTION_FEE = "ADD_TRANSACTION_FEE";
    public static final String EDIT_TRANSACTION_FEE = "EDIT_TRANSACTION_FEE";
    public static final String DELETE_TRANSACTION_FEE = "DELETE_TRANSACTION_FEE";
    public static final String LIST_TRANSACTION_FEE = "LIST_TRANSACTION_FEE";
    public static final String VIEW_ACCESS_HISTORY = "VIEW_ACCESS_HISTORY";
    public static final String LIST_ACCESS_HISTORY = "LIST_ACCESS_HISTORY";
    public static final String VIEW_COUNTRY = "VIEW_COUNTRY";
    public static final String ADD_COUNTRY = "ADD_COUNTRY";
    public static final String EDIT_COUNTRY = "EDIT_COUNTRY";
    public static final String DELETE_COUNTRY = "DELETE_COUNTRY";
    public static final String LIST_COUNTRY = "LIST_COUNTRY";
    public static final String VIEW_LANGUAGE = "VIEW_LANGUAGE";
    public static final String ADD_LANGUAGE = "ADD_LANGUAGE";
    public static final String EDIT_LANGUAGE = "EDIT_LANGUAGE";
    public static final String DELETE_LANGUAGE = "DELETE_LANGUAGE";
    public static final String LIST_LANGUAGE = "LIST_LANGUAGE";
    public static final String ADD_MERCHANT_KYC = "ADD_MERCHANT_KYC";
    public static final String EDIT_MERCHANT_KYC = "EDIT_MERCHANT_KYC";
    public static final String VIEW_MERCHANT_KYC = "VIEW_MERCHANT_KYC";
    public static final String ADD_USER_KYC = "ADD_USER_KYC";
    public static final String EDIT_USER_KYC = "EDIT_USER_KYC";
    public static final String VIEW_USER_KYC = "VIEW_USER_KYC";
    public static final String EDIT_MERCHANT_KYC_STATUS = "EDIT_MERCHANT_KYC_STATUS";
    public static final String EDIT_USER_KYC_STATUS = "EDIT_USER_KYC_STATUS";
    public static final String LIST_MERCHANT_KYC = "LIST_MERCHANT_KYC";
    public static final String VIEW_MERCHANT_ADDRESS = "VIEW_MERCHANT_ADDRESS";
    public static final String ADD_MERCHANT_ADDRESS = "ADD_MERCHANT_ADDRESS";
    public static final String EDIT_MERCHANT_ADDRESS = "EDIT_MERCHANT_ADDRESS";
    public static final String DELETE_MERCHANT_ADDRESS = "DELETE_MERCHANT_ADDRESS";
    public static final String LIST_MERCHANT_ADDRESS = "LIST_MERCHANT_ADDRESS";
    public static final String VIEW_MERCHANT_DASHBOARD = "VIEW_MERCHANT_DASHBOARD";
    public static final String VIEW_MERCHANT_POS_MANAGER = "VIEW_MERCHANT_POS_MANAGER";
    public static final String ADD_MERCHANT_POS_MANAGER = "ADD_MERCHANT_POS_MANAGER";
    public static final String EDIT_MERCHANT_POS_MANAGER = "EDIT_MERCHANT_POS_MANAGER";
    public static final String DELETE_MERCHANT_POS_MANAGER = "DELETE_MERCHANT_POS_MANAGER";
    public static final String LIST_MERCHANT_POS_MANAGER = "LIST_MERCHANT_POS_MANAGER";
    public static final String VIEW_MERCHANT_POS = "VIEW_MERCHANT_POS";
    public static final String ADD_MERCHANT_POS = "ADD_MERCHANT_POS";
    public static final String EDIT_MERCHANT_POS = "EDIT_MERCHANT_POS";
    public static final String DELETE_MERCHANT_POS = "DELETE_MERCHANT_POS";
    public static final String LIST_MERCHANT_POS = "LIST_MERCHANT_POS";
    public static final String VIEW_MERCHANT_PROFILE = "VIEW_MERCHANT_PROFILE";
    public static final String ADD_MERCHANT_PROFILE = "ADD_MERCHANT_PROFILE";
    public static final String EDIT_MERCHANT_PROFILE = "EDIT_MERCHANT_PROFILE";
    public static final String DELETE_MERCHANT_PROFILE = "DELETE_MERCHANT_PROFILE";
    public static final String ADD_MERCHANT_PROFILE_BANK = "ADD_MERCHANT_PROFILE_BANK";
    public static final String ADD_MERCHANT_PROFILE_BANK_BRANCH =
        "ADD_MERCHANT_PROFILE_BANK_BRANCH";
    public static final String ADD_MERCHANT_PROFILE_MOBILE_OPERATOR =
        "ADD_MERCHANT_PROFILE_MOBILE_OPERATOR";
    public static final String ADD_MERCHANT_PROFILE_CARD_TYPE = "ADD_MERCHANT_PROFILE_CARD_TYPE";
    public static final String LIST_MERCHANT_PROFILE_BANK = "LIST_MERCHANT_PROFILE_BANK";
    public static final String LIST_MERCHANT_PROFILE_MOBILE_OPERATOR =
        "LIST_MERCHANT_PROFILE_MOBILE_OPERATOR";
    public static final String LIST_MERCHANT_PROFILE_CARD_TYPE = "LIST_MERCHANT_PROFILE_CARD_TYPE";
    public static final String DELETE_MERCHANT_PROFILE_BANK = "DELETE_MERCHANT_PROFILE_BANK";
    public static final String DELETE_MERCHANT_PROFILE_MOBILE_OPERATOR =
        "DELETE_MERCHANT_PROFILE_MOBILE_OPERATOR";
    public static final String DELETE_MERCHANT_PROFILE_CARD_TYPE =
        "DELETE_MERCHANT_PROFILE_CARD_TYPE";
    public static final String VIEW_MERCHANT_BARCODE = "VIEW_MERCHANT_BARCODE";
    public static final String VIEW_MERCHANT_QRCODE = "VIEW_MERCHANT_QRCODE";
    public static final String VIEW_MERCHANT_SHOP = "VIEW_MERCHANT_SHOP";
    public static final String ADD_MERCHANT_SHOP = "ADD_MERCHANT_SHOP";
    public static final String EDIT_MERCHANT_SHOP = "EDIT_MERCHANT_SHOP";
    public static final String DELETE_MERCHANT_SHOP = "DELETE_MERCHANT_SHOP";
    public static final String LIST_MERCHANT_SHOP = "LIST_MERCHANT_SHOP";
    public static final String LIST_SHOP_MANAGER_SHOP = "LIST_SHOP_MANAGER_SHOP";
    public static final String LIST_SHOP_MANAGER_SHOP_POS = "LIST_SHOP_MANAGER_SHOP_POS";
    public static final String LIST_SHOP_MANAGER_SHOP_POS_MANAGER =
        "LIST_SHOP_MANAGER_SHOP_POS_MANAGER";
    public static final String LIST_POS_MANAGER_POS = "LIST_POS_MANAGER_POS";
    public static final String LIST_POS_MANAGER_POS_MANAGER = "LIST_POS_MANAGER_POS_MANAGER";
    public static final String VIEW_MERCHANT_SHOP_MANAGER = "VIEW_MERCHANT_SHOP_MANAGER";
    public static final String ADD_MERCHANT_SHOP_MANAGER = "ADD_MERCHANT_SHOP_MANAGER";
    public static final String EDIT_MERCHANT_SHOP_MANAGER = "EDIT_MERCHANT_SHOP_MANAGER";
    public static final String DELETE_MERCHANT_SHOP_MANAGER = "DELETE_MERCHANT_SHOP_MANAGER";
    public static final String LIST_MERCHANT_SHOP_MANAGER = "LIST_MERCHANT_SHOP_MANAGER";
    public static final String VIEW_MERCHANT_SUBSCRIPTION = "VIEW_MERCHANT_SUBSCRIPTION";
    public static final String ADD_MERCHANT_SUBSCRIPTION = "ADD_MERCHANT_SUBSCRIPTION";
    public static final String RENEW_MERCHANT_SUBSCRIPTION = "RENEW_MERCHANT_SUBSCRIPTION";
    public static final String DOWNGRADE_MERCHANT_SUBSCRIPTION = "DOWNGRADE_MERCHANT_SUBSCRIPTION";
    public static final String LIST_MERCHANT_SUBSCRIPTION = "LIST_MERCHANT_SUBSCRIPTION";
    public static final String LIST_MERCHANT_SUBSCRIPTION_PAYMENT_METHOD =
        "LIST_MERCHANT_SUBSCRIPTION_PAYMENT_METHOD";
    public static final String ADD_TRIAL_MERCHANT_SUBSCRIPTION = "ADD_TRIAL_MERCHANT_SUBSCRIPTION";
    public static final String VIEW_USER_DASHBOARD = "VIEW_USER_DASHBOARD";
    public static final String VIEW_USER_PROFILE = "VIEW_USER_PROFILE";
    public static final String ADD_USER_PROFILE = "ADD_USER_PROFILE";
    public static final String EDIT_USER_PROFILE = "EDIT_USER_PROFILE";
    public static final String VIEW_TICKET_REPLY = "VIEW_TICKET_REPLY";
    public static final String ADD_TICKET_REPLY = "ADD_TICKET_REPLY";
    public static final String EDIT_TICKET_REPLY = "EDIT_TICKET_REPLY";
    public static final String DELETE_TICKET_REPLY = "DELETE_TICKET_REPLY";
    public static final String LIST_TICKET_REPLY = "LIST_TICKET_REPLY";
    public static final String VIEW_CONFIGURATION = "VIEW_CONFIGURATION";
    public static final String EDIT_CONFIGURATION = "EDIT_CONFIGURATION";
    public static final String LIST_CONFIGURATION = "LIST_CONFIGURATION";
    public static final String VIEW_MERCHANT_ROLE = "VIEW_MERCHANT_ROLE";
    public static final String ADD_MERCHANT_ROLE = "ADD_MERCHANT_ROLE";
    public static final String EDIT_MERCHANT_ROLE = "EDIT_MERCHANT_ROLE";
    public static final String DELETE_MERCHANT_ROLE = "DELETE_MERCHANT_ROLE";
    public static final String LIST_MERCHANT_ROLE = "LIST_MERCHANT_ROLE";
    public static final String LIST_EMAIL_TEMPLATE = "LIST_EMAIL_TEMPLATE";
    public static final String EDIT_EMAIL_TEMPLATE = "EDIT_EMAIL_TEMPLATE";
    public static final String DOWNLOAD_POSMERCHANT_CREDENTIAL = "DOWNLOAD_POSMERCHANT_CREDENTIAL";
    public static final String ADD_PSP_TRANSACTION_FEE = "ADD_PSP_TRANSACTION_FEE";
    public static final String EDIT_PSP_TRANSACTION_FEE = "EDIT_PSP_TRANSACTION_FEE";
    public static final String DELETE_PSP_TRANSACTION_FEE = "DELETE_PSP_TRANSACTION_FEE";
    public static final String LIST_PSP_TRANSACTION_FEE = "LIST_PSP_TRANSACTION_FEE";
    public static final String VIEW_PSP_TRANSACTION_FEE = "VIEW_PSP_TRANSACTION_FEE";
    public static final String VIEW_MERCHANT_ACCOUNT_BALANCE = "VIEW_MERCHANT_ACCOUNT_BALANCE";
    public static final String VIEW_MERCHANT_ACCOUNT_HISTORY = "VIEW_MERCHANT_ACCOUNT_HISTORY";
    public static final String VIEW_MERCHANT_CLIENT_TRANSACTION = "VIEW_MERCHANT_CLIENT_TRANSACTION";
    public static final String VIEW_ADMIN_TRANSACTION_SETTLEMENT = "VIEW_ADMIN_TRANSACTION_SETTLEMENT";
    public static final String VIEW_ADMIN_ACCOUNT_BALANCE = "VIEW_ADMIN_ACCOUNT_BALANCE";
    public static final String VIEW_ADMIN_ACCOUNT_HISTORY = "VIEW_ADMIN_ACCOUNT_HISTORY";
    public static final String VIEW_ADMIN_TRANSACTION_INFO = "VIEW_ADMIN_TRANSACTION_INFO";

    public static final String LIST_SETTLEMENT_FIRST_LEVEL_APPROVAL =
        "LIST_SETTLEMENT_FIRST_LEVEL_APPROVAL";
    public static final String APPROVE_SETTLEMENT_FIRST_LEVEL_APPROVAL =
        "APPROVE_SETTLEMENT_FIRST_LEVEL_APPROVAL";
    public static final String LIST_SETTLEMENT_SECOND_LEVEL_APPROVAL =
        "LIST_SETTLEMENT_SECOND_LEVEL_APPROVAL";
    public static final String APPROVE_SETTLEMENT_SECOND_LEVEL_APPROVAL =
        "APPROVE_SETTLEMENT_SECOND_LEVEL_APPROVAL";

    public static final String VIEW_SETTLEMENT_DETAILS = "VIEW_SETTLEMENT_DETAILS";

    public static final String VIEW_DISBURSEMENT_ACCOUNTS_LIST = "VIEW_DISBURSEMENT_ACCOUNTS_LIST";
    public static final String UPDATE_OR_CREATE_DISBURSEMENT_ACCOUNT =
        "UPDATE_OR_CREATE_DISBURSEMENT_ACCOUNT";

    public static final String ADD_SECURITY_QUESTION = "ADD_SECURITY_QUESTION";
    public static final String EDIT_SECURITY_QUESTION = "EDIT_SECURITY_QUESTION";
    public static final String DELETE_SECURITY_QUESTION = "DELETE_SECURITY_QUESTION";

    public static final String ADD_SECURITY_ANSWER = "ADD_SECURITY_ANSWER";
    public static final String EDIT_SECURITY_ANSWER = "EDIT_SECURITY_ANSWER";
    public static final String DELETE_SECURITY_ANSWER = "DELETE_SECURITY_ANSWER";
    public static final String LIST_SECURITY_ANSWER = "LIST_SECURITY_ANSWER";

    public static final String LIST_SETTLEMENT_RANGE = "LIST_SETTLEMENT_RANGE";
    public static final String ADD_SETTLEMENT_RANGE = "ADD_SETTLEMENT_RANGE";
    public static final String EDIT_SETTLEMENT_RANGE = "EDIT_SETTLEMENT_RANGE";
    public static final String DELETE_SETTLEMENT_RANGE = "DELETE_SETTLEMENT_RANGE";

    public static final String LIST_MERCHANT_SETTLEMENT = "LIST_MERCHANT_SETTLEMENT";
    public static final String VIEW_MERCHANT_SETTLEMENT = "VIEW_MERCHANT_SETTLEMENT";
    public static final String ADD_MERCHANT_SETTLEMENT = "ADD_MERCHANT_SETTLEMENT";

    public static final String VIEW_PAY_LINK = "VIEW_PAY_LINK";

    public static final String LIST_USER_GROUP = "LIST_USER_GROUP";
    public static final String VIEW_USER_GROUP = "VIEW_USER_GROUP";
    public static final String EDIT_USER_GROUP = "EDIT_USER_GROUP";
    public static final String ADD_USER_GROUP = "ADD_USER_GROUP";
    public static final String DELETE_USER_GROUP = "DELETE_USER_GROUP";

    public static final String LIST_MESSAGE = "LIST_MESSAGE";
    public static final String VIEW_MESSAGE = "VIEW_MESSAGE";
    public static final String ADD_MESSAGE = "ADD_MESSAGE";
    public static final String EDIT_MESSAGE = "EDIT_MESSAGE";
    public static final String DELETE_MESSAGE = "DELETE_MESSAGE";

    public static final String LIST_MERCHANT_PAYMENT_METHOD = "LIST_MERCHANT_PAYMENT_METHOD";

    public static final String LIST_MERCHANT_PAY_LINK = "LIST_MERCHANT_PAY_LINK";
    public static final String VIEW_MERCHANT_PAY_LINK = "VIEW_MERCHANT_PAY_LINK";
    public static final String ADD_MERCHANT_PAY_LINK = "ADD_MERCHANT_PAY_LINK";
    public static final String EDIT_MERCHANT_PAY_LINK = "EDIT_MERCHANT_PAY_LINK";
    public static final String DELETE_MERCHANT_PAY_LINK = "DELETE_MERCHANT_PAY_LINK";

    public static final String LIST_INVOICE = "LIST_INVOICE";
    public static final String VIEW_INVOICE = "VIEW_INVOICE";
    public static final String ADD_INVOICE = "ADD_INVOICE";
    public static final String EDIT_INVOICE = "EDIT_INVOICE";
    public static final String DELETE_INVOICE = "DELETE_INVOICE";

    public static final String LIST_QUOTATION = "LIST_QUOTATION";
    public static final String VIEW_QUOTATION = "VIEW_QUOTATION";
    public static final String ADD_QUOTATION = "ADD_QUOTATION";
    public static final String EDIT_QUOTATION = "EDIT_QUOTATION";
    public static final String DELETE_QUOTATION = "DELETE_QUOTATION";

    public static final String LIST_CUSTOMER = "LIST_CUSTOMER";
    public static final String VIEW_CUSTOMER = "VIEW_CUSTOMER";
    public static final String ADD_CUSTOMER = "ADD_CUSTOMER";
    public static final String EDIT_CUSTOMER = "EDIT_CUSTOMER";
    public static final String DELETE_CUSTOMER = "DELETE_CUSTOMER";

    public static final String LIST_PRODUCT = "LIST_PRODUCT";
    public static final String VIEW_PRODUCT = "VIEW_PRODUCT";
    public static final String ADD_PRODUCT = "ADD_PRODUCT";
    public static final String EDIT_PRODUCT = "EDIT_PRODUCT";
    public static final String DELETE_PRODUCT = "DELETE_PRODUCT";

    public static final String LIST_COUPON = "LIST_COUPON";
    public static final String VIEW_COUPON = "VIEW_COUPON";
    public static final String ADD_COUPON = "ADD_COUPON";
    public static final String EDIT_COUPON = "EDIT_COUPON";
    public static final String DELETE_COUPON = "DELETE_COUPON";

    public static final String LIST_BILLING = "LIST_BILLING";
    public static final String VIEW_BILLING = "VIEW_BILLING";
    public static final String ADD_BILLING = "ADD_BILLING";
    public static final String EDIT_BILLING = "EDIT_BILLING";
    public static final String DELETE_BILLING = "DELETE_BILLING";

    public static final String LIST_ADMIN_GROUP = "LIST_ADMIN_GROUP";
    public static final String VIEW_ADMIN_GROUP = "VIEW_ADMIN_GROUP";
    public static final String ADD_ADMIN_GROUP = "ADD_ADMIN_GROUP";
    public static final String EDIT_ADMIN_GROUP = "EDIT_ADMIN_GROUP";
    public static final String DELETE_ADMIN_GROUP = "DELETE_ADMIN_GROUP";

    public static final String LIST_EVENT = "LIST_ADMIN_GROUP";
    public static final String VIEW_EVENT = "VIEW_ADMIN_GROUP";
    public static final String ADD_EVENT = "ADD_ADMIN_GROUP";
    public static final String EDIT_EVENT = "EDIT_ADMIN_GROUP";
    public static final String DELETE_EVENT = "DELETE_ADMIN_GROUP";

    public static final String LIST_LOYALTY = "LIST_LOYALTY";
    public static final String VIEW_LOYALTY = "VIEW_LOYALTY";
    public static final String ADD_LOYALTY = "ADD_LOYALTY";
    public static final String EDIT_LOYALTY = "EDIT_LOYALTY";
    public static final String DELETE_LOYALTY = "DELETE_LOYALTY";

    public static final String LIST_SETTLEMENT = "LIST_SETTLEMENT";

    public static final String VIEW_ADMIN_DASHBOARD = "VIEW_ADMIN_DASHBOARD";

    public static final String LIST_CAMPAIGN = "LIST_CAMPAIGN";
    public static final String VIEW_CAMPAIGN = "VIEW_CAMPAIGN";
    public static final String ADD_CAMPAIGN = "ADD_CAMPAIGN";
    public static final String EDIT_CAMPAIGN = "EDIT_CAMPAIGN";
    public static final String DELETE_CAMPAIGN = "DELETE_CAMPAIGN";

    public static final String LIST_LOYALTY_EVENT = "LIST_LOYALTY_EVENT";
    public static final String VIEW_LOYALTY_EVENT = "VIEW_LOYALTY_EVENT";
    public static final String ADD_LOYALTY_EVENT = "ADD_LOYALTY_EVENT";
    public static final String EDIT_LOYALTY_EVENT = "EDIT_LOYALTY_EVENT";
    public static final String DELETE_LOYALTY_EVENT = "DELETE_LOYALTY_EVENT";

    public static final String VIEW_SETTLEMENT_METHOD = "VIEW_SETTLEMENT_METHOD";
    public static final String ADD_SETTLEMENT_METHOD = "ADD_SETTLEMENT_METHOD";
    public static final String EDIT_SETTLEMENT_METHOD = "EDIT_SETTLEMENT_METHOD";
    public static final String DELETE_SETTLEMENT_METHOD = "DELETE_SETTLEMENT_METHOD";
    public static final String LIST_SETTLEMENT_METHOD = "LIST_SETTLEMENT_METHOD";
    public static final String SUSPEND_MERCHANT = "SUSPEND_MERCHANT";
    public static final String VIEW_SUSPEND_REPORT = "VIEW_SUSPEND_REPORT";

    public static final String SUSPEND_USER = "SUSPEND_USER";

    public static final String LIST_USER_LOYALTY_GROUP = "LIST_USER_LOYALTY_GROUP";
    public static final String VIEW_USER_LOYALTY_GROUP = "VIEW_USER_LOYALTY_GROUP";
    public static final String ADD_USER_LOYALTY_GROUP = "ADD_USER_LOYALTY_GROUP";
    public static final String EDIT_USER_LOYALTY_GROUP = "EDIT_USER_LOYALTY_GROUP";
    public static final String DELETE_USER_LOYALTY_GROUP = "DELETE_USER_LOYALTY_GROUP";
    public static final String ADD_USER_TO_USER_LOYALTY_GROUP = "ADD_USER_TO_USER_LOYALTY_GROUP";
    public static final String REMOVE_USER_FROM_USER_LOYALTY_GROUP =
        "REMOVE_USER_FROM_USER_LOYALTY_GROUP";

    public static final String BUY_LOYALTY_POINTS = "BUY_LOYALTY_POINTS";
    public static final String GIFT_LOYALTY_POINTS = "GIFT_LOYALTY_POINTS";
    public static final String TRANSFER_LOYALTY_POINTS = "TRANSFER_LOYALTY_POINTS";

    public static final String ADD_KYC_REJECTION_REASON = "ADD_KYC_REJECTION_REASON";
    public static final String EDIT_KYC_REJECTION_REASON = "EDIT_KYC_REJECTION_REASON";
    public static final String IDM_SUPER_ADMIN = "IDM_SUPER_ADMIN";

    public static final String REVERSE_TRANSACTION = "REVERSE_TRANSACTION";

    public static final String PAYOUT_INIT = "PAYOUT_INIT";
    public static final String PAYOUT_PROCESS = "PAYOUT_PROCESS";
    public static final String PAYOUT_MANUAL_COMPLETE = "PAYOUT_MANUAL_COMPLETE";

    public static final String MERCHANT_MONEY_TRANSFER_INIT = "MERCHANT_MONEY_TRANSFER_INIT";
    public static final String MERCHANT_MONEY_TRANSFER_PROCESS = "MERCHANT_MONEY_TRANSFER_PROCESS";

  }

  public class Role {
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_MAKER = "ROLE_MAKER";
    public static final String ROLE_CHECKER = "ROLE_CHECKER";
    public static final String ROLE_USER = "ROLE_USER";
    public static final String ROLE_MERCHANT = "ROLE_MERCHANT";
    public static final String ROLE_MERCHANT_POS_MANAGER = "ROLE_MERCHANT_POS_MANAGER";
    public static final String ROLE_MERCHANT_SHOP_MANAGER = "ROLE_MERCHANT_SHOP_MANAGER";
  }
}
