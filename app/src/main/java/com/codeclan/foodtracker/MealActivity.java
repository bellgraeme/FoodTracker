package com.codeclan.foodtracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MealActivity extends AppCompatActivity {

    public final static String ITEMS = "items";
    Larder larder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);

        larder.getLarder();


    }
}
