package com.example.listpersonsjosefine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Crud extends AppCompatActivity {

    public static final String endpoint = "http://10.0.2.2:8080/DemoWebProj/api/person";
    public Button Update;
    public Button Delete;
    public ListView viewperson;
    List<Personmodel> personmodelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);

        Update = findViewById(R.id.Update);
        Delete = findViewById(R.id.Delete);
        viewperson = findViewById(R.id.ViewName);

        personmodelList = new ArrayList<>();


        loadPersonList();

        Update.setOnClickListener(new View.OnClickListener()
        {


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Crud.this, UpdatePerson.class);
                intent.putExtra("Read", "update");
                startActivityForResult(intent, 3);
            }
        });
        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Crud.this, DeletePerson.class);
                intent.putExtra("Read", "delete");
                startActivityForResult(intent, 4);
            }
        });

        Dataservice dataService = new Dataservice(this);
        dataService.getJsonObject(endpoint, new Responselistener() {
            @Override
            public void onDataReady(JSONObject json) {

                try {

                    JSONObject obj = new JSONObject();

                    JSONArray personArray = obj.getJSONArray("person");

                    //now looping through all the elements of the json array
                    for (int i = 0; i < personArray.length(); i++) {

                        JSONObject personObject = personArray.getJSONObject(i);

                        Personmodel person = new Personmodel(personObject.getString("fullname"), personObject.getString("email"), personObject.getString("note"));

                        personmodelList.add(person);
                    }

                    //creating custom adapter object
                    Adapter adapter = new Adapter(personmodelList, getApplicationContext());

                    //adding the adapter to listview
                    viewperson.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }


            @Override
            public void onDataReady(JSONArray json) {


            }

            @Override
            public void onErrorResonse(String err) {
                Toast.makeText(Crud.this, err, Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void loadPersonList() {
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);

        //making the progressbar visible
        progressBar.setVisibility(View.VISIBLE);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, endpoint,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressBar.setVisibility(View.INVISIBLE);

                        try {
                            //getting the whole json object from the response
                            JSONObject obj = new JSONObject(response);

                            //we have the array named hero inside the object
                            //so here we are getting that json array
                            JSONArray personArray = obj.getJSONArray("person");

                            //now looping through all the elements of the json array
                            for (int i = 0; i < personArray.length(); i++) {
                                //getting the json object of the particular index inside the array
                                JSONObject personObject = personArray.getJSONObject(i);

                                //creating a person object and giving them the values from json object
                                Personmodel person = new Personmodel(personObject.getString("fullname"), personObject.getString("email"), personObject.getString("note"));

                                //adding the person to personlist
                                personmodelList.add(person);
                            }

                            //creating custom adapter object
                            Adapter adapter = new Adapter(personmodelList, getApplicationContext());

                            //adding the adapter to listview
                            viewperson.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //displaying the error in toast if occurrs
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        //creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //adding the string request to request queue
        requestQueue.add(stringRequest);
    }
    }

