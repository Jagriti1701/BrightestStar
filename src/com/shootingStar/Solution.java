package com.shootingStar;

import com.shootingStar.dao.Location;
import com.shootingStar.exceptions.ShootingStarException;
import com.shootingStar.service.ShootingStarService;
import com.shootingStar.service.impl.ShootingStarServiceImpl;
import com.shootingStar.utils.Constants;
import com.shootingStar.utils.Messages;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws ShootingStarException {
        //user inputs taken
        Location boston = new Location("Boston", 42.354558, 71.054254, "N", "W");
        Location ncr = new Location("NCR", 28.574389, 77.312638, "N", "E");
        Location sanFran = new Location("San Francisco", 37.793700, 122.403906, "N", "W");
        List<Location> DelphixLocations = new ArrayList<>();

        //Test case 1 : add all locations shared in assignment, original case
        DelphixLocations.add(boston);
        DelphixLocations.add(ncr);
        DelphixLocations.add(sanFran);

        //Test case 2 : add only 2 locations , comment other test cases
        //DelphixLocations.add(ncr);
        //DelphixLocations.add(sanFran);

        //Test case 3 : send empty location list, comment other test cases

        if (!DelphixLocations.isEmpty()) {
            ShootingStarService shootingStarService = new ShootingStarServiceImpl();
            //after receiving shooting stars for every location, we print the brightest shooting star
            System.out.println(shootingStarService.getBrightestShootingStar(DelphixLocations, Constants.API_DATE_FILTER));
        }
        else
            System.out.println(Messages.INSUFFICIENT_DATA);

    }

}
