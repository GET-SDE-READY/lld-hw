package com.restaurant.burgerfactory;

public class BeefBurgerRestaurant {

    public Burger createBurger(String request) {
        if (request.equalsIgnoreCase("BEEF")) {
            return new BeefBurger();
        } else {
            return null;

        }
        
    }
}
