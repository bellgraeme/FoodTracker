package com.codeclan.foodtracker;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Meal {

    private String  name;
    private Date date;
    private HashMap<Item, Integer> ingredients;

    public Meal(String name, Date date) {
        this.name = name;
        this.ingredients = new HashMap<Item, Integer>();
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<Item, Integer> getIngredients() {
        return ingredients;
    }

    public void setIngredients(HashMap<Item, Integer> ingredients) {
        this.ingredients = ingredients;
    }


    public Integer itemTotalCalories(){
        HashMap<Item, Integer> ingredients = this.ingredients;
        Integer itemCalories = 0;
        for(Item item : ingredients.keySet()){
            itemCalories += item.getCalories();

        }
        return itemCalories;
    }

    public Integer itemTotalMealWeight(){
        Integer mealSize = 0;
    HashMap<Item, Integer> ingredients = this.ingredients;
        for(Integer item : ingredients.values()){
        mealSize += item;
        }
    return  mealSize;
    }

    public void totalCalories(){
        HashMap<Item, Integer> ingredients = this.ingredients;

    }

    public Integer getTotalCaloriesPerCent(){
        HashMap<Item, Integer> ingredients = this.ingredients;
        Integer itemCalories = 0;
        Integer mealSize = 0;
        for(Item item : ingredients.keySet()){
            itemCalories += item.getCalories();
        }
        for(Integer item : ingredients.values()){
            mealSize += item;
        }
        Integer averageCaloriePerCent = (itemCalories/ingredients.size());
        Integer number = averageCaloriePerCent/100;
        Integer totalCalorie = mealSize * number;

        return totalCalorie;
    }


    public void addItemToMeal(Item item, Integer amount){
        this.ingredients.put(item, amount);
    }
}
