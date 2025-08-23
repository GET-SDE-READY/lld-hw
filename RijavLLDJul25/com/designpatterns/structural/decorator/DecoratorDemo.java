package designpatterns.RijavLLDJul25.com.designpatterns.structural.decorator;

public class DecoratorDemo {
    public static void main(String[] args) {
        Coffee coffee = new RegularCoffee();
        coffee = new MilkCoffeeDecorator(coffee);
        coffee = new AddedSugarDecorator(coffee);
        System.out.println(coffee.getDescription() + " → Rs. " + coffee.cost());
    }
}
