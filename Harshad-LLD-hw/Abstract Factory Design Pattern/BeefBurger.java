package com.restaurant.burgerfactory;

public class BeefBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing a Beef Burger");
    }

}
