package coffeeMaker;

abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;
    protected String name;
    protected Double cost;

    public CoffeeDecorator(Coffee coffee, String name, Double cost) {
        this.coffee = coffee;
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return String.format("%s%s", this.coffee.getName(), this.name);
    }

    public Double getCost() {
        return this.coffee.getCost() + this.cost;
    }
}
