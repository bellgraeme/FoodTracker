package com.codeclan.foodtracker;


import java.util.ArrayList;
import java.util.Date;

public class Diary implements Comparable<Meal>{

    private ArrayList<Meal> diary;

    public Diary(){
        this.diary = new ArrayList<Meal>();
    }
    @Override
    public int compareTo(Meal meal){

    }



    public ArrayList<Meal> getDiary() {
        return diary;
    }

    public void addMeal(Meal meal){
        this.diary.add(meal);
    }

    public Meal findMealByName(String name){
        for(Meal item : this.diary)
          if ( item.getName().equals(name))
              return item;
        return null;
    }

    public ArrayList<Meal> findAllMealsbyDate(Date date){
        ArrayList<Meal> result = new ArrayList<Meal>();
        for(int i = 0; i < this.diary.size(); i++){
            if(date.equals(this.diary.get(i).getDate())){
                result.add(this.diary.get(i));
            }
        }
        return result;
    }
}
