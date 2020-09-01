package com.shootingStar.utils;

/**
 * The messages used in various outputs and error description
 *
 */
public class Messages {

    public static final String INSUFFICIENT_DATA = "Insufficient Data provided";
    public static final String API_NO_DATA = "Sufficient Data Points are not available for given co-ordinates. " +
            "Please check in some time!!";
    public static final String BRIGHTEST_LOCATION = "Delphix Brightest Star is at ";
    public static final String BRIGHTEST_STAR_ENERGY = " with energy ";
    public static final String BAD_REQUEST = "The request contained invalid keywords and/or content";
    public static final String METHOD_NOT_ALLOWED = "The request used a method other than GET or POST";
    public static final String INTERNAL_SERVER_ERROR = "The database is not available at the time of the request";
    public static final String SERVICE_UNAVAILABLE = "The server is currently unable to handle the request due to a " +
            "temporary overloading or maintenance of the server, which will likely be alleviated after some delay";
}
