package com.example.listpersonsjosefine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONObject;

public class UpdatePerson extends AppCompatActivity {
    public static  final String endpoint = "http://10.0.2.2:8080/DemoWebProj/api/person";
    EditText name;
    EditText email;
    EditText note;
    Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_person);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        note = findViewById(R.id.note);
        update = findViewById(R.id.send);
        Dataservice dataservice = new Dataservice(this);
        dataservice.putJsonObject(endpoint, new Responselistener() {
            @Override
            public void onDataReady(JSONObject json) {
                name.setText(json.toString());
                email.setText(json.toString());
                note.setText(json.toString());

            }

            @Override
            public void onDataReady(JSONArray json) {

            }

            @Override
            public void onErrorResonse(String err) {

            }
        });
    }
}