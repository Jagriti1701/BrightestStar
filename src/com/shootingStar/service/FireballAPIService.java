package com.shootingStar.service;

import com.shootingStar.dao.Fireball;

import java.util.List;

/**
 * FireballAPIService is used for FireBall Data API
 *
 */
public interface FireballAPIService {
    public List<Fireball> getDataFromAPICall(String minDate);
}
