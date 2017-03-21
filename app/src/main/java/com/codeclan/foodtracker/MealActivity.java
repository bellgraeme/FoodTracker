package com.codeclan.foodtracker;
import android.view.View;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.DatePicker;


import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static com.codeclan.foodtracker.MainActivity.FOODTRACKER;


public class MealActivity extends AppCompatActivity {
    private Meal meal;
    private DatePicker datePicker;
    private Calendar calendar;
    private int year, month, day;
    private Larder larder;
    private Spinner[] spinners;
    private String name;
    private Item item1;
    private Item item2;
    private Item item3;
    private Item item4;
    private Item item5;
    private int foodWeight111;
    private int foodWeight222;
    private int foodWeight333;
    private int foodWeight444;
    private int foodWeight555;
    Date date;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        larder = new Larder();
        larder.getLarder();
        ArrayList<String> names = larder.getNames();

        spinners = new  Spinner [5];
        spinners[0] = (Spinner) findViewById(R.id.spinner1);
        spinners[1] = (Spinner) findViewById(R.id.spinner2);
        spinners[2] = (Spinner) findViewById(R.id.spinner3);
        spinners[3] = (Spinner) findViewById(R.id.spinner4);
        spinners[4] = (Spinner) findViewById(R.id.spinner8);


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, names);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        for(Spinner item : spinners){
            item.setAdapter(dataAdapter);
            item.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String name = parent.getItemAtPosition(position).toString();
                    parent.getItemAtPosition(position);
                    switch (parent.getId()) {
                        case R.id.spinner1:
                            String itemName1 = parent.getContext().toString();
                            item3 = larder.getItemByName(itemName1);
                            break;
                        case R.id.spinner2:
                            String itemName2 = parent.getContext().toString();
                            item1 = larder.getItemByName(itemName2);
                            break;
                        case R.id.spinner3:
                            String itemName3 = parent.getContext().toString();
                            item3   = larder.getItemByName(itemName3);
                            break;
                        case R.id.spinner4:
                            String itemName4 = parent.getContext().toString();
                            item4 = larder.getItemByName(itemName4);
                            break;
                        case R.id.spinner8:
                            String itemName5 = parent.getContext().toString();
                            item2 = larder.getItemByName(itemName5);
                            break;
                    }

                }

                public void onNothingSelected(AdapterView<?> arg0) {
                    // TODO Auto-generated method stub
                }

            });
        }

        EditText foodWeight1 = (EditText) findViewById(R.id.editText6);
        String foodWeight11 = foodWeight1.getText().toString();
        foodWeight111 = Integer.parseInt(foodWeight11);
        EditText foodWeight2 = (EditText) findViewById(R.id.editText10);
        String foodWeight22 = foodWeight2.getText().toString();
        foodWeight222 = Integer.parseInt(foodWeight22);
        EditText foodWeight3 = (EditText) findViewById(R.id.editText9);
        String foodWeight33 = foodWeight3.getText().toString();
        foodWeight333 = Integer.parseInt(foodWeight33);
        EditText foodWeight4 = (EditText) findViewById(R.id.editText8);
        String foodWeight44 = foodWeight4.getText().toString();
        foodWeight444 = Integer.parseInt(foodWeight44);
        EditText foodWeight5 = (EditText) findViewById(R.id.editText7);
        String foodWeight55 = foodWeight5.getText().toString();
        foodWeight555 = Integer.parseInt(foodWeight55);
        EditText mealName = (EditText) findViewById(R.id.meal_name);
        name = mealName.getText().toString();


        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);


    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "ca",
                Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {

                    arg1= year;
                    arg2 = month;
                    arg3 = day;

                    StringBuilder input;


                    if(month < 10) {
                        input = new StringBuilder().append(year).append("-").append(0)
                                .append(month + 1).append("-").append(day);
                    }
                    else{
                     input = new StringBuilder().append(year).append("-")
                            .append(month + 1).append("-").append(day);}

                String newString = input.toString();



                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    try{
                        date = formatter.parse(newString);
                        Log.d("date",date.toString());
                    }
                    catch(Exception ex) {

                    }

                }
            };

    public void createMeal(View view){
        meal.addItemToMeal(item1, foodWeight111);
        meal.addItemToMeal(item2, foodWeight222);
        meal.addItemToMeal(item3, foodWeight333);
        meal.addItemToMeal(item4, foodWeight444);
        meal.addItemToMeal(item5, foodWeight555);
        meal.setDate(date);
        meal.setName(name);
        meal.zeroWeight();

        Log.d("meal",  meal.getName() + meal.getDate().toString() + meal.getTotalCalories().toString());


    }



    public void addMealToSharedPreferences(View view){
    SharedPreferences sharedPref = getSharedPreferences(FOODTRACKER, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        Gson gson = new Gson();

        //Add Meals to sharedPrefs as a JSON String. Then Apply.
        editor.putString("Meal", gson.toJson(larder));
        editor.apply();

        Toast.makeText(MealActivity.this, "Meal added to Diary", Toast.LENGTH_LONG).show();
    }





}
