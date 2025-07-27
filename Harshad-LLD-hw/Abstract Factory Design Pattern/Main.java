package com.restaurant.burgerfactory;

public class Main {
    public static void main() {
        Restaurant restaurant = new VeggieBurgerRestaurant();
        Burger burger = restaurant.orderBurger("Veggie");
    }
}
