package designpatterns.RijavLLDJul25.com.designpatterns.structural.decorator;

public class RegularCoffee implements Coffee {

    @Override
    public String getDescription() {
        return "Regular Coffee";
    }

    @Override
    public double cost() {
        return 149.0;
    }
}
