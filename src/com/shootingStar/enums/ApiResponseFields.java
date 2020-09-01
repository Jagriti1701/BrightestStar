package com.shootingStar.enums;

/**
 * Used to specify data fields coming from FireBall Api
 *
 * @com.shootingStar.enums
 */
public enum ApiResponseFields {

        DATE(0),
        ENERGY(1),
        TOTAL_IMPACTED_ENERGY(2),
        LATITUDE(3),
        LATITUDE_DIRECTION(4),
        LONGITUDE(5),
        LONGITUDE_DIRECTION(6),
        ALTITUDE(7),
        VELOCITY(8);

        private int value;

        // enum constructor - cannot be public or protected
        private ApiResponseFields(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
}
