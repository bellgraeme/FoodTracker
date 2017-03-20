package com.codeclan.foodtracker;

import android.content.Intent;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

import static com.codeclan.foodtracker.MainActivity.FOODTRACKER;


public class MealActivity extends AppCompatActivity {


    Spinner spinner1;
    Spinner spinner2;
    Spinner spinner3;
    Spinner spinner4;
    Spinner spinner8;


    Larder larder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);

        larder = new Larder();
        larder.getLarder();
        Spinner spinners[] = new  Spinner [5];
        ArrayList<String> names = larder.getNames();
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner4 = (Spinner) findViewById(R.id.spinner4);
        spinner8 = (Spinner) findViewById(R.id.spinner8);


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, names);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);
        spinner2.setAdapter(dataAdapter);
        spinner3.setAdapter(dataAdapter);
        spinner4.setAdapter(dataAdapter);
        spinner8.setAdapter(dataAdapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String name = parent.getItemAtPosition(position).toString();

                Item item = larder.getItemByName(name);
                Log.d("Logged:",  name);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




    }

    public void addListToSharedPreferences(View view){
    SharedPreferences sharedPref = getSharedPreferences(FOODTRACKER, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        Gson gson = new Gson();

        //Add guitarList to sharedPrefs as a JSON String. Then Apply.
        editor.putString("Meals", gson.toJson(larder));
        editor.apply();

        Toast.makeText(MealActivity.this, "Meal added to Diary", Toast.LENGTH_LONG).show();
    }
}
