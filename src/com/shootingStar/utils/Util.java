package com.shootingStar.utils;
/**
 * utilities required for various conditions
 *
 */
public class Util {

    public static boolean isInclusive(double x, double min, double max) {
        return x > min && x < max;
    }

    public static boolean isNull(Object... objects) {
        for (Object obj : objects) {
            if (obj == null) {
                return true;
            }
        }
        return false;
    }
}
