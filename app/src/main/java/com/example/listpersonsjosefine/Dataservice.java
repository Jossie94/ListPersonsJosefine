package com.example.listpersonsjosefine;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONObject;


public class Dataservice {
    Context context;

    public Dataservice(Context context) {
        this.context = context;
    }

    // Request for JSON object
    public void getJsonObject(String url, Responselistener listener) {
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //jsonObject[0] = response;
                        listener.onDataReady(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        listener.onErrorResonse(error.getMessage());
                    }
                }
        );
        Singleton.getInstance(context).addToRequestQueue(request);
    }

    public void postJsonObject(String url, Responselistener listener) {
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //jsonObject[0] = response;
                        listener.onDataReady(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        listener.onErrorResonse(error.getMessage());
                    }
                }
        );
        Singleton.getInstance(context).addToRequestQueue(request);
    }

    public void putJsonObject(String url, Responselistener listener) {
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.PUT,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //jsonObject[0] = response;
                        listener.onDataReady(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        listener.onErrorResonse(error.getMessage());
                    }
                }
        );
        Singleton.getInstance(context).addToRequestQueue(request);
    }

    public void deleteJsonObject(String url, Responselistener listener) {
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.DELETE,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //jsonObject[0] = response;
                        listener.onDataReady(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        listener.onErrorResonse(error.getMessage());
                    }
                }
        );
        Singleton.getInstance(context).addToRequestQueue(request);
    }

    // Request for JSON-Array object
   /* public void getJsoArrayObject(String url, Responselistener listener) {
        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //jsonObject[0] = response;
                        listener.onDataReady(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        listener.onErrorResonse(error.getMessage());
                    }
                }
        );
        Singleton.getInstance(context).addToRequestQueue(request);

    }*/

}
