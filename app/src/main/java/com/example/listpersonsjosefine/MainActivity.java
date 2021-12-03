package com.example.listpersonsjosefine;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    Button person;
    Button newpers;
    public static final String endpoint = "http://localhost:8080/DemoWebProj/api/person";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        person = findViewById(R.id.list);
        person.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Crud.class);
            intent.putExtra("Read", "Person");
            startActivityForResult(intent, 0);
        });

        newpers = findViewById(R.id.newperson);
        newpers.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Newperson.class);
            intent.putExtra("Read", "create");
            startActivityForResult(intent, 1);
        });


        Dataservice dataService = new Dataservice(this);
        dataService.getJsonObject(endpoint, new Responselistener() {
            @Override
            public void onDataReady(JSONObject json) {
                try {
                    String test = json.getString("people");
                } catch (JSONException e) {
                    // Skrive kode der håndterer JSON-fejl
                    Log.d("FEJL", e.getMessage());
                }
                // Skrive kode der håndterer json objectet
                //person.setText(json.toString());
            }

            @Override
            public void onDataReady(JSONArray json) { }


            @Override
            public void onErrorResonse(String err) {
                // Skrive kode der håndterer HTTP-fejl
                Toast.makeText(MainActivity.this, err, Toast.LENGTH_SHORT).show();
            }
        });
    }
   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (resultCode == Activity.RESULT_OK) {
                String Name = data.getStringExtra("name");
                person = findViewById(R.id.list);
                //person.setText(Name);
            }
        }
    }*/

}