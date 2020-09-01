package com.shootingStar.exceptions;

import com.shootingStar.enums.HttpErrorCodes;

public class ShootingStarException extends Exception {

    private static final long serialVersionUID = 1L;

    private HttpErrorCodes errorCode;

    public ShootingStarException(String message, HttpErrorCodes errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public HttpErrorCodes getErrorCode() {
        return errorCode;
    }
}
