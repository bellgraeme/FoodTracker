package com.codeclan.foodtracker;


import org.junit.*;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class TestMeal {

    Meal meal;
    Item item;

    @Before
    public void before(){
        Date date = new Date(17, 3, 12);
        meal = new Meal("lunch", date );
        Item carrot = new Item("carrot", 40,0,0,35);
        Item sausage = new Item("sausage",70,10,10,15);
        Item potato = new Item("potato", 60,2,0,80);
        Item milk = new Item("milk", 55,10,5,60);
        Item beer = new Item("beer", 200,0,0,60);
        meal.addItemToMeal(carrot, 100);
        meal.addItemToMeal(sausage, 100);
    }

    @Test
    public void testIngredientLength(){
        assertEquals(2, meal.getIngredients().size());
    }
    @Test
    public void testTotalCalories(){
        assertEquals((Integer)110 , meal.getTotalCaloriesPerCent());
    }

    @Test
    public void testTotalFood(){
        assertEquals((Integer)110 , meal.itemTotalCalories());
    }

    @Test
    public void testMealSize(){
        assertEquals((Integer)200, meal.itemTotalMealWeight());
    }

    @Test
    public void testCalories(){
        Integer itemCalories = meal.itemTotalCalories();
        Integer mealSize = meal.itemTotalMealWeight();
        Integer numberItem = meal.getIngredients().size();
        Integer avgCalories = (itemCalories/numberItem)/100;
        Integer result = avgCalories*mealSize;
        assertEquals((Integer)110, result);

    }
}
