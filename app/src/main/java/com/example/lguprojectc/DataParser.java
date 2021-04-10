package com.example.lguprojectc;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataParser {

    private HashMap<String, String>getPlace(JSONObject googlePlaceJson)
    {
        HashMap<String , String>googlePlaceMap = new HashMap<>();
        String placeName = "-NA-";
        String vicinity = "-NA-";
        String latittude = "";
        String longlittude = "";
        String reference =  "";

        try {
            if(!googlePlaceJson.isNull("name")){

                placeName = googlePlaceJson.getString("name");


            }
            if(!googlePlaceJson.isNull("vicinity")){
                vicinity = googlePlaceJson.getString("vicinity");
            }
            latittude = googlePlaceJson.getJSONObject("geometry").getJSONObject("location").getString("lat");
            longlittude = googlePlaceJson.getJSONObject("geometry").getJSONObject("location").getString("lng");

            reference = googlePlaceJson.getString("reference");

            googlePlaceMap.put("place_name" , placeName);
            googlePlaceMap.put("vicinity" , vicinity);
            googlePlaceMap.put("lat" , latittude);
            googlePlaceMap.put("lng" , longlittude);
            googlePlaceMap.put("reference" , reference);

        }catch (JSONException e) {
            e.printStackTrace();
        }

        return googlePlaceMap;

    }

    private List<HashMap<String ,  String>> getPlaces(JSONArray jsonArray)
    {

        int count = jsonArray.length();
        List<HashMap<String , String>> placesList = new ArrayList<>();
        HashMap<String, String> placeMap = null;

        for(int i = 0 ; i<count;i++)
        {
            try {
                placeMap = getPlace((JSONObject) jsonArray.get(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return  placesList;

    }
    public List<HashMap<String, String>> parse(String jsonData){
        JSONArray jsonArray = null;
        JSONObject jsonObject;

        try {
            jsonObject = new JSONObject(jsonData);
            jsonArray = jsonObject.getJSONArray("results");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  getPlaces(jsonArray);
    }
}

