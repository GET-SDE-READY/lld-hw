package designpatterns.RijavLLDJul25.com.designpatterns.structural.decorator;

public abstract class CoffeeaDecorator implements Coffee {
    protected Coffee coffee;
    public CoffeeaDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
    public String getDescription() {
        return coffee.getDescription();
    }
    public double cost() {
        return coffee.cost();
    }
}
