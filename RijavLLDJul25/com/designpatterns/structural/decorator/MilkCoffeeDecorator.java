package designpatterns.RijavLLDJul25.com.designpatterns.structural.decorator;

public class MilkCoffeeDecorator extends CoffeeaDecorator {
    public MilkCoffeeDecorator(Coffee coffee) {
        super(coffee);
    }
    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }
    public double cost() {
        return coffee.cost() + 10.5;
    }
}
