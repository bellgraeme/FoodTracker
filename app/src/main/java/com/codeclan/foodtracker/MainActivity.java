package com.codeclan.foodtracker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String ITEMS = "Items";
    public static final String MEALS = "Meals";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        SharedPreferences sharedPref1 = getSharedPreferences(ITEMS, Context.MODE_PRIVATE);
//        SharedPreferences sharedPref2 = getSharedPreferences(MEALS, Context.MODE_PRIVATE);
        SharedPreferences sharedPref = getSharedPreferences(FOODTRACKER, Context.MODE_PRIVATE);

        String items = sharedPref.getString("items", "Nothing here");
        String meals = sharedPref.getString("meals", "Nothing here");

        Diary diary = new Diary();
        ArrayList<Meal> list = diary.getDiary();

        DiaryAdapter diaryAdapter = new DiaryAdapter(this, list);

        ListView listview = (ListView)findViewById(R.id.diary_list);
        listview.setAdapter(diaryAdapter);
    }

    public void createMealButtonClicked(View button){
        Intent intent = new Intent(this, MealActivity.class);
        startActivity(intent);
    }



}

