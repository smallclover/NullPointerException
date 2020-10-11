package com.smallclover.nullpointerexception.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smallclover.nullpointerexception.model.Journey;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Amadeus
 * @Date: 2020/5/14 18:28
 */
public class Object2Json {

    private static ObjectMapper mapper = new ObjectMapper();

    public static <T> String list2Json(List<T> targetList){
        String result = null;
        try {
            result = mapper.writeValueAsString(targetList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        Journey journey = new Journey();
        journey.setId(1);
        journey.setTitle("清庭澄园");
        journey.setDesc("清庭澄园");
        journey.setDeleteFlag(false);
        journey.setLatitude("35.680742");
        journey.setLongitude("139.797792");
        var journeys = new ArrayList<Journey>();
        journeys.add(journey);
        String res = list2Json(journeys);
        System.out.println(res);
    }
}
