package com.codeclan.foodtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Diary diary = new Diary();
        ArrayList<Meal> list = diary.getDiary();

        DiaryAdapter diaryAdapter = new DiaryAdapter(this, list);

        ListView listview = (ListView)findViewById(R.id.diary_list);
        listview.setAdapter(diaryAdapter);
    }

    public void createMealButtonClicked(){
        Intent intent = new Intent(this, MealActivity.class);
        startActivity(intent);
    }



}

