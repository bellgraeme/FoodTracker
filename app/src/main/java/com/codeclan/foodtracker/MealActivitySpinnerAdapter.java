package com.codeclan.foodtracker;


import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MealActivitySpinnerAdapter extends ArrayAdapter {

    ArrayList<Item> larder1;

    public MealActivitySpinnerAdapter(Context context, ArrayList<Item> larder1){
        super(context,0, larder1);
        this.larder1 = larder1;
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        listItemView = inflater.inflate(R.layout.item_item, parent, true);

        TextView food = (TextView) listItemView.findViewById(R.id.text_view);
        Item item = larder1.get(position);
        String name = item.getName();
        food.setText(name);

        return listItemView;
    }


}
