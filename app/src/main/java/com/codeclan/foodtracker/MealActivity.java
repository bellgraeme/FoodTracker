package com.codeclan.foodtracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MealActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public final static String ITEMS = "items";
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
}
