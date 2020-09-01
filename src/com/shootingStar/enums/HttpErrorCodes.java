package com.shootingStar.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Used to specify http error codes and their messages
 *
 * @com.shootingStar.enums
 */
public enum HttpErrorCodes {

    OK(200),
    BAD_REQUEST(400),
    METHOD_NOT_ALLOWED(405),
    INTERNAL_SERVER_ERROR(500),
    SERVICE_UNAVAILABLE(503);

    // declaring private variable for getting values
    private int value;

    // enum constructor - cannot be public or protected, default private
    HttpErrorCodes(int value) {
        this.value = value;
    }

    private static HashMap<Integer,HttpErrorCodes> map = new HashMap<>();


    static {
        for (HttpErrorCodes httpResponseCodes : HttpErrorCodes.values()) {
            map.put(httpResponseCodes.value, httpResponseCodes);
        }
    }

    public static HttpErrorCodes valueOf(int httpResponseCodes) {
        return (HttpErrorCodes) map.get(httpResponseCodes);
    }

    public int getValue() {
        return value;
    }
}

