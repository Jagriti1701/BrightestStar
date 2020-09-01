package com.shootingStar.dao;
import java.util.Objects;
/**
 * To store every location data
 *
 */
public class Location {

    private String name;
    private double latitude;
    private double longitude;
    private String latDirection;
    private String longDirection;

    public Location(String name, double latitude, double longitude, String latDirection, String longDirection) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.latDirection = latDirection;
        this.longDirection = longDirection;
    }

    public Location() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getLatDirection() {
        return latDirection;
    }

    public void setLatDirection(String latDirection) {
        this.latDirection = latDirection;
    }

    public String getLongDirection() {
        return longDirection;
    }

    public void setLongDirection(String longDirection) {
        this.longDirection = longDirection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return Double.compare(location.getLatitude(), getLatitude()) == 0 &&
                Double.compare(location.getLongitude(), getLongitude()) == 0 &&
                Objects.equals(getName(), location.getName()) &&
                getLatDirection() == location.getLatDirection() &&
                getLongDirection() == location.getLongDirection();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getLatitude(), getLongitude(),
                getLatDirection(), getLongDirection());
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", latDirection=" + latDirection +
                ", longDirection=" + longDirection +
                '}';
    }
}
