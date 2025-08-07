package coffeeMaker;

class BaseCoffee implements Coffee {

    String name = "Plain Coffee";
    Double cost = 45.0;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getCost() {
        return cost;
    }
}


