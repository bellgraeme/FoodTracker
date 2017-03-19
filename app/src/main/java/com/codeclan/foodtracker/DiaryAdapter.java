package com.codeclan.foodtracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DiaryAdapter extends ArrayAdapter<Meal> {

    public DiaryAdapter(Context context, ArrayList<Meal> meals) {
        super(context, 0, meals);

    }
    @Override
    public View getView(int position, View listItemView, ViewGroup parent){

        if(listItemView == null){

            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.meal_item, parent, false);
        }

        Meal currentMeal = getItem(position);

        TextView mealName = (TextView)listItemView.findViewById(R.id.mealName);
        mealName.setText(currentMeal.getName());

        TextView mealDate = (TextView)listItemView.findViewById(R.id.mealDate);
        mealDate.setText(currentMeal.getDate().toString());

        return listItemView;
    }
}
