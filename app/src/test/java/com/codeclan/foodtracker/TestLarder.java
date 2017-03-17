package com.codeclan.foodtracker;


import android.util.Log;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class TestLarder {


    Larder larder;
    Item carrot;
    Item sausage;

    @Before
    public void before() {
        larder = new Larder();
        Item carrot = new Item("carrot", 40, 0, 0, 35);
        Item sausage = new Item("sausage", 70, 10, 10, 15);
        Item potato = new Item("potato", 60, 2, 0, 80);
        Item milk = new Item("milk", 55, 10, 5, 60);
        Item beer = new Item("beer", 200, 0, 0, 60);
        larder.addItemToLarder(carrot);
        larder.addItemToLarder(sausage);
        larder.addItemToLarder(potato);
        larder.addItemToLarder(milk);
        larder.addItemToLarder(beer);
    }

    @Test
    public void testLarderSize(){
        assertEquals(5, larder.getLarderSize());
    }


}