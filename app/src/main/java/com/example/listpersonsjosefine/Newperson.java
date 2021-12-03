package com.example.listpersonsjosefine;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

public class Newperson extends AppCompatActivity implements View.OnClickListener{

    public static  final String endpoint = "http://10.0.2.2:8080/DemoWebProj/api/person";
    public EditText fullname;
    public EditText email;
    public EditText note;
    public Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newperson);
        fullname = findViewById(R.id.name);
        email = findViewById(R.id.email);
        note = findViewById(R.id.note);
        send = findViewById(R.id.send);
        send.setOnClickListener(this);
        Dataservice dataservice = new Dataservice(this);
        dataservice.postJsonObject(endpoint, new Responselistener()

        {
            @Override
            public void onDataReady(JSONObject json) {

                fullname.setText(json.toString());
                email.setText(json.toString());
                note.setText(json.toString());

            }

            @Override
            public void onDataReady(JSONArray json) {

            }

            @Override
            public void onErrorResonse(String err) {

            }
             /*@Override
             protected Map<String, String> getParams()
             {
                 Map<String>
             }*/

        });


    }

        @Override
        public void onClick(View v) {

            //String Name = name.getText().toString();
            Intent intent1 = new Intent();
            //intent1.putExtra("Name", name);
            setResult(Activity.RESULT_OK, intent1);

            finish();
        }

    /*
    @Override
    protected Map<String, String> getParams()
    {
            Map<String, String>  params = new HashMap<String, String>();
            params.put("name", "Alif");
            params.put("domain", "http://itsalif.info");

            return params;
    }
};
queue.add(postRequest);
     */





    }




/*
    public static final String SWAPI_DEV_API = "https://swapi.dev/api/";
    private TextView txtData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtData = findViewById(R.id.txtData);
        SwapiDataService dataService = new SwapiDataService(this);
        dataService.getJsonObject(SWAPI_DEV_API, new SwapiResponseListener() {
            @Override
            public void onDataReady(JSONObject json) {
                try {
                    String test = json.getString("people");
                } catch (JSONException e) {
                    // Skrive kode der håndterer JSON-fejl
                    Log.d("FEJL", e.getMessage());
                }
                // Skrive kode der håndterer json objectet
                txtData.setText(json.toString());
            }

            @Override
            public void onDataReady(JSONArray json) { }

            @Override
            public void onErrorResonse(String err) {
                // Skrive kode der håndterer HTTP-fejl
                Toast.makeText(MainActivity.this, err, Toast.LENGTH_SHORT).show();
            }
        });*/