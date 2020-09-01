package com.shootingStar.service;

import com.shootingStar.dao.Location;
import com.shootingStar.exceptions.ShootingStarException;

import java.util.List;
/**
 * ShootingStarService is used to find brightest star
 *
 */
public interface ShootingStarService {

    String getBrightestShootingStar(List<Location> locations, String minDate) throws ShootingStarException;

}
