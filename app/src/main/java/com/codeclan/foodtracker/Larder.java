package com.codeclan.foodtracker;


import java.util.ArrayList;

public class Larder {

    ArrayList<Item> larder;

    public Larder() {
        this.larder = new ArrayList<Item>();
        larder.add(new Item("carrot", 40,0,0,35));
        larder.add(new Item("sausage",70,10,10,15));
        larder.add(new Item("potato", 60,2,0,80));
        larder.add(new Item("milk", 55,10,5,60));
        larder.add(new Item("beer", 200,0,0,60));
    }

    public ArrayList<Item> getLarder() {
        return new ArrayList<Item>(larder) ;
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
