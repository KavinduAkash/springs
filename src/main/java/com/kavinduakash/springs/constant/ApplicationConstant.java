package com.kavinduakash.springs.constant;

public class ApplicationConstant {

    /**
     * API Response
     */
    public static final String API_BASE_URL = "/v1";

    /**
     * Exception error message constants
     */
    //don't use this variable for other error messages (only exception class use)
    public static final String APPLICATION_ERROR_OCCURRED_MESSAGE = "Application Error Occurred";


    /**
     * Error Codes
     */
    public static final int COMMON_ERROR_CODE = 100;
    public static final int TOO_MANY_REQUESTS = 105;

    public static final int RESOURCE_NOT_FOUND = 404;
    public static final int DUPLICATE_CORPORATE_CODE = 603;
    public static final int DUPLICATE_BRC = 604;
    public static final int INVALID_ENTERED = 609;

    public static final int CANT_WIRTE_FILE = 500;
    public static final int DELETED_RESOURCE = 603;
    public static final int PASSWORD_FORMAT_WRONG = 501;
    public static final int INVALID_PASSWORD_ENTERED = 502;
    public static final int INACTIVE_ACCOUNT = 605;
    public static final int PASSWORDS_ARE_SAME = 703;
    public static final int INCORRECT_PASSWORD = 704;
    public static final int LIMIT_EXCEEDED = 704;
    public static final int OTP_TIME_OUT = 723;

    public static final int ADMIN_USER_NAME_DUPLICATE = 605;
    public static final int ADMIN_USER_EMAIL_DUPLICATE = 606;
    public static final int DUPLICATE_IDENTIFICATION_VALUE = 600;
    public static final int DUPLICATE_EMAIL = 601;
    public static final int DUPLICATE_MOBILE = 602;
    public static final int DUPLICATE_EMP_ID = 603;
    public static final int DUPLICATE_SUBSCRIPTION_NUMBER= 604;
    public static final int EXTERNAL_RECEPTION_NOT_ALLOWED = 607;
    public static final int ADMIN_USER_MOBILE_DUPLICATE = 608;

    public static final int UNAUTHORIZED_REQUEST = 405;
    public static final int VERIFICATION_FAILED = 101;
    public static final int BULK_UPLOAD_DATA_ERROR = 723;

    public static final int USER_NOT_FOUND = 404;
    public static final int REQUEST_NOT_FOUND = 405;
    public static final int CATEGORY_NOT_FOUND = 406;
    public static final int EMAIL_ALL_READY_EXIST = 407;

    public static final int MULTIPART_FILE_SAVE_ERROR = 300;

    public static final int DUPLICATE_UNIQUE_RECORDS = 309;

    public static final int INVALID_DATE_FORMAT = 802;
    public static final int INVALID_MOBILE_NUMBER = 816;

    //et seller
    public static final int ET_SELLER_DUPLICATE = 605;


    // email
    public static final int EMAIL_SENDING_ERROR = 498;
    public static final int SELLER_NOT_FOUND = 408;
    public static final int PACKAGE_NOT_FOUND = 412;
    public static final int PROMO_CODE_NOT_FOUND = 411;

    /**
     * Token sign in key
     */
    public static final String TOKEN_SIGN_IN_KEY = "w*KLT+Q9$L8Sa@BB";

    /**
     * Status code
     */
    public static final int EXISTING_B2B_BUYER = 600;
    public static final int EXISTING_E_TENDER_SELLER = 602;

    /**
     * Payment error codes
     */
    public static final int WEBXPAY_ERROR = 801;
    public static final int PAYMENT_CAL_ERROR = 802;

    /**
     * Promo code codes
     */
    public static final int INACTIVE_PROMO_CODE = 301;
    public static final int EXPIRED_PROMO_CODE = 302;
    public static final int INVALID_PROMO_CODE = 303;
}
