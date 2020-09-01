package com.shootingStar.service.impl;

import com.shootingStar.dao.Fireball;
import com.shootingStar.enums.HttpErrorCodes;
import com.shootingStar.exceptions.ShootingStarException;
import com.shootingStar.service.FireballAPIService;
import com.shootingStar.utils.Messages;
import com.shootingStar.utils.Util;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.shootingStar.enums.ApiResponseFields.*;
import static com.shootingStar.enums.HttpErrorCodes.*;
import static com.shootingStar.utils.Constants.*;

/**
 * FireballAPIServiceImpl is used for FireBall Data API
 *
 */
public class FireballAPIServiceImpl implements FireballAPIService {

    @Override
    public List<Fireball> getDataFromAPICall(String minDate) {
        try {
            StringBuilder url = new StringBuilder(API_URL.concat("?date-min=").
                    concat(minDate).concat("&req-loc=true"));
            var request = HttpRequest.newBuilder()
                    .uri(URI.create(url.toString()))
                    .build();
            return handleResponse(HttpClient.newHttpClient().send(request,
                    HttpResponse.BodyHandlers.ofString()));
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    private List<Fireball> handleResponse(HttpResponse<String> response) throws ShootingStarException, ParseException {
        HttpErrorCodes codes = valueOf(response.statusCode());

        switch (codes) {
            case OK:
                return handleBody(String.valueOf(response.body()));
            case BAD_REQUEST:
                throw new ShootingStarException(Messages.BAD_REQUEST, BAD_REQUEST);
            case METHOD_NOT_ALLOWED:
                throw new ShootingStarException(Messages.METHOD_NOT_ALLOWED, METHOD_NOT_ALLOWED);
            case INTERNAL_SERVER_ERROR:
                throw new ShootingStarException(Messages.INTERNAL_SERVER_ERROR, INTERNAL_SERVER_ERROR);
            case SERVICE_UNAVAILABLE:
                throw new ShootingStarException(Messages.SERVICE_UNAVAILABLE, SERVICE_UNAVAILABLE);
            default:
                return Collections.emptyList();
        }
    }

    private List<Fireball> handleBody(String response) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(response);
        int count = Integer.valueOf(json.get("count").toString());

        if (THRESHOLD_CAPACITY > count)
            return Collections.emptyList();

        JSONArray array = new JSONArray();
        array.add(json.get("data"));

        return getLocationDataPoints(count, array);
    }

    private List<Fireball> getLocationDataPoints(int count, JSONArray array) {
        List<Fireball> fireballs = new ArrayList<>(count);
        Fireball fireball;
        for (int i = 0; i < count; i++) {
            JSONArray jsonArray = (JSONArray) ((JSONArray) array.get(0)).get(i);
            if (Util.isNull(jsonArray.get(TOTAL_IMPACTED_ENERGY.getValue()),
                    jsonArray.get(LATITUDE.getValue()),
                    jsonArray.get(LATITUDE_DIRECTION.getValue()),
                    jsonArray.get(LONGITUDE.getValue()),
                    jsonArray.get(LONGITUDE_DIRECTION.getValue())))
                continue;
            fireball = new Fireball();
            fireball.setTotalImpactEnergy(Double.parseDouble(
                    jsonArray.get(TOTAL_IMPACTED_ENERGY.getValue()).toString()));
            fireball.setLatitude(Double.parseDouble(jsonArray.get(LATITUDE.getValue()).toString()));
            fireball.setLatDir(jsonArray.get(LATITUDE_DIRECTION.getValue()).toString());
            fireball.setLongitude(Double.parseDouble(jsonArray.get(LONGITUDE.getValue()).toString()));
            fireball.setLongDir(jsonArray.get(LONGITUDE_DIRECTION.getValue()).toString());
            fireballs.add(fireball);
        }
        return fireballs;
    }
}
