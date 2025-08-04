package com.restaurant.burgerfactory;

public class VeggieBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing a Veggie Burger");
    }
}