package com.codeclan.foodtracker;


import org.junit.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class TestDiary {

    Meal meal;
    Diary diary;

    @Before
    public void before() {
        diary = new Diary();
        Date date = new Date(17, 3, 12);
        Date date1 = new Date(18, 3, 12);
        Date date2 = new Date(19, 3, 12);
        Date date3 = new Date(20, 3, 12);
        Date date4 = new Date(21, 3, 12);
        Date date5 = new Date(22, 3, 12);
        meal = new Meal("lunch", date);
        Meal meal2 = new Meal("lunch", date1);
        Meal meal3 = new Meal("lunch", date2);
        Meal meal4 = new Meal("lunch", date3);
        Meal meal5 = new Meal("lunch", date4);
        Meal meal6 = new Meal("lunch", date5);
        Item carrot = new Item("carrot", 40, 0, 0, 35);
        Item sausage = new Item("sausage", 70, 10, 10, 15);
        Item potato = new Item("potato", 60, 2, 0, 80);
        Item milk = new Item("milk", 55, 10, 5, 60);
        Item beer = new Item("beer", 200, 0, 0, 60);
        meal.addItemToMeal(carrot, 100);
        meal.addItemToMeal(sausage, 100);
        diary.addMeal(meal);
        diary.addMeal(meal2);
        diary.addMeal(meal3);
        diary.addMeal(meal4);
        diary.addMeal(meal5);
        diary.addMeal(meal6);

    }

    @Test
    public void testDateRangeSearch(){
        Date date1 = new Date(18, 3, 12);
        Date date4 = new Date(21, 3, 12);
        ArrayList<Meal> result = diary.findMealDateRange(date1, date4 );

        assertEquals(3, diary.getDiary().size() );
    }
}