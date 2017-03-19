package com.codeclan.foodtracker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Diary {

    private ArrayList<Meal> diary;

    public Diary(){
        this.diary = new ArrayList<Meal>();
        Date date =  new Date();
        date.getTime();
        Meal meal1 = new Meal("someMeal", date);
        Meal meal2 = new Meal("someMeal", date);
        Meal meal3 = new Meal("someMeal", date);
        Meal meal4 = new Meal("someMeal", date);
        Meal meal5 = new Meal("someMeal", date);
        Meal meal6 = new Meal("someMeal", date);
        diary.add(meal1);
        diary.add(meal2);
        diary.add(meal3);
        diary.add(meal4);
        diary.add(meal5);
        diary.add(meal6);

    }




    public ArrayList<Meal> getDiary() {
        return new ArrayList<Meal>(diary);
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



    public ArrayList<Meal> findAllMealsByDate(Date date){
        ArrayList<Meal> result = new ArrayList<Meal>();
        for(int i = 0; i < this.diary.size(); i++){
            if(date.equals(this.diary.get(i).getDate())){
                result.add(this.diary.get(i));
            }
        }
        return result;
    }

    public static Calendar toCalendar(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    public ArrayList<Meal>findMealDateRange(Date start, Date end){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.UK);
        Calendar startDate2 = toCalendar(start);
        Calendar endDate2 = toCalendar(end);
        ArrayList<Meal> result = new ArrayList<Meal>();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(start);
        while (calendar.getTime().before(end)) {
            for (Meal item : this.diary){
                Calendar cal = toCalendar(item.getDate());
                if (formatter.format(calendar).equals(formatter.format(cal))) {
                    result.add(item);}
            }
            calendar.add(Calendar.DATE, 1);
        }
        return result;
    }


}
