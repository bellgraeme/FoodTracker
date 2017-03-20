package com.codeclan.foodtracker;

import android.content.Intent;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

import static com.codeclan.foodtracker.MainActivity.MEALS;

public class MealActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    Larder larder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);
        larder = new Larder();
        ArrayList<Item> larder1 = larder.getLarder();

        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        spinner.setOnItemSelectedListener(this);

        MealActivitySpinnerAdapter adapter = new MealActivitySpinnerAdapter(getApplicationContext(), larder1);

//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        Item item = (Item) parent.getItemAtPosition(position);
        String name = item.getName();
        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + name, Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    public void addListToSharedPreferences(View view){
        SharedPreferences sharedPref = getSharedPreferences(MEALS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        Gson gson = new Gson();

        //Add guitarList to sharedPrefs as a JSON String. Then Apply.
        editor.putString("Meals", gson.toJson(larder));
        editor.apply();

        Toast.makeText(MealActivity.this, "Meal added to Diary", Toast.LENGTH_LONG).show();
    }
}
