package com.codeclan.foodtracker;


import java.util.ArrayList;

public class Larder {

    ArrayList<Item> larder;

    public Larder() {
        this.larder = new ArrayList<Item>();
    }

    public ArrayList<Item> getLader() {
        return larder;
    }

    public void addItemToLarder(Item item){
        this.larder.add(item);
    }

    public Item getItemByName(String name){
        for(Item item : this.larder){
            if(item.getName().equals(name)){
                return item;
            }
        }
        return null;
    }



    public int getLarderSize(){
        return this.larder.size();
    }



}
