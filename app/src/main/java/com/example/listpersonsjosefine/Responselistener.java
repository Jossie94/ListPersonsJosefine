package com.example.listpersonsjosefine;

import org.json.JSONArray;
import org.json.JSONObject;

public interface Responselistener {
    public void onDataReady(JSONObject json);
    public void onDataReady(JSONArray json);
    public void onErrorResonse(String err);
}
