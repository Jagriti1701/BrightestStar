package com.shootingStar.utils;
/**
 * constants and assumptions which will never change
 *
 */
public final class Constants {

    private Constants() {
    }

    public final static String API_URL = "https://ssd-api.jpl.nasa.gov/fireball.api";
    public final static String API_DATE_FILTER = "2017-01-01";
    public final static int LAT_LONG_RANGE = 15;
    public final static int THRESHOLD_CAPACITY = 2; //assumption
}
