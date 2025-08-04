package com.restaurant.burgerfactory;

abstract class Restaurant {
    public Burger orderBurger(String request) {
        Burger burger = createBurger(request);
        burger.prepare();
        return burger;
}
    abstract Burger createBurger(String request);
}
    
    

