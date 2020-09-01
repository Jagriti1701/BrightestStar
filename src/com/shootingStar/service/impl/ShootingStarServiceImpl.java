package com.shootingStar.service.impl;

import com.shootingStar.dao.Fireball;
import com.shootingStar.dao.Location;

import com.shootingStar.exceptions.ShootingStarException;
import com.shootingStar.service.FireballAPIService;
import com.shootingStar.service.ShootingStarService;

import java.util.ArrayList;
import java.util.List;

import com.shootingStar.utils.Messages;
import com.shootingStar.utils.Util;

import static com.shootingStar.utils.Constants.*;

/**
 * ShootingStarServiceImpl is used to find brightest star
 *
 */
public class ShootingStarServiceImpl implements ShootingStarService {

    List<Fireball> fireballDataPoints;

    @Override
    public String getBrightestShootingStar(List<Location> locationInputs, String minDate)
            throws ShootingStarException {

        //Data is fetched as per date filter , avoiding redundant calls to api
        //It avoids slow system and unstable
        FireballAPIService apiService=new FireballAPIServiceImpl();
        fireballDataPoints = apiService.getDataFromAPICall(minDate);

        if (fireballDataPoints.isEmpty()) {
            return Messages.API_NO_DATA;
        }
        List<Object> getBrightestStar= getBrightestStarDetails(locationInputs, fireballDataPoints);
        return Messages.BRIGHTEST_LOCATION + getBrightestStar.get(0)
                +Messages.BRIGHTEST_STAR_ENERGY+ getBrightestStar.get(1);
    }

    private List<Object> getBrightestStarDetails(List<Location> locationInputs, List<Fireball> fireballDataPoints) {
        double maxBrightness = Integer.MIN_VALUE;
        double brightness;
        List<Object> getBrightestStar =new ArrayList<>();
        String brightestStar = "";

        for (Location locationInput : locationInputs) {
            brightness=fireball(locationInput.getLatitude(),locationInput.getLongitude(),locationInput);
            if(maxBrightness<brightness)
            {
                maxBrightness=brightness;
                brightestStar=locationInput.getName();
            }
        }
        getBrightestStar.add(brightestStar);
        getBrightestStar.add(maxBrightness);
        return getBrightestStar;
    }

    double fireball(double latitude, double longitude, Location locationInput){
        double latMin, latMax, longMin, longMax;
        double maxBrightnessPerLoc = Integer.MIN_VALUE;

        latMin = latitude - LAT_LONG_RANGE;
        latMax = latitude + LAT_LONG_RANGE;
        longMin = longitude - LAT_LONG_RANGE;
        longMax = longitude + LAT_LONG_RANGE;

        for (Fireball fireball : fireballDataPoints) {
            if (fireball.getLatDir().equalsIgnoreCase(locationInput.getLatDirection())
                    && fireball.getLongDir().equalsIgnoreCase(locationInput.getLongDirection())) {
                if (Util.isInclusive(fireball.getLatitude(), latMin, latMax)
                        && Util.isInclusive(fireball.getLongitude(), longMin, longMax)) {
                    if (maxBrightnessPerLoc < fireball.getTotalImpactEnergy()) {
                        maxBrightnessPerLoc = fireball.getTotalImpactEnergy();
                    }
                }
            }
        }
        return maxBrightnessPerLoc;
    }

}
