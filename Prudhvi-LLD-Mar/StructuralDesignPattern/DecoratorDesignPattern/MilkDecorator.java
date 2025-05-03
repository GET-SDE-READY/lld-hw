package DecoratorDesignPattern;

public class MilkDecorator extends CoffeeDecorator{

  public MilkDecorator(CoffeeService coffeeService) {
    super(coffeeService);
  }

  public String getName() {
    return super.getName().concat(", added milk");
  }

  public Double getPrice() {
    return super.getPrice() + 20.0;
  }
}
