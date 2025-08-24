package designpatterns.RijavLLDJul25.com.designpatterns.structural.decorator;

public class AddedSugarDecorator extends CoffeeaDecorator{
    public AddedSugarDecorator(Coffee coffee) {
        super(coffee);
    }
    public String getDescription() {
        return coffee.getDescription() + ", Sugar";
    }
    public double cost() {
        return coffee.cost() + 2.5;
    }
}
