package com.restaurant.burgerfactory;


public class VeggieBurgerRestaurant extends Restaurant {
    @Override
    public Burger createBurger(String request) {
        if (request.equalsIgnoreCase("veggie")) {
            return new VeggieBurger();
        } else {
            return null;
        }
        
    }

}
