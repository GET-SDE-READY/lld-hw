package DecoratorDesignPattern;

public class SugarDecorator extends CoffeeDecorator{

  public SugarDecorator(CoffeeService coffeeService) {
    super(coffeeService);
  }

  public String getName() {
    return super.getName().concat(", added sugar");
  }

  public Double getPrice() {
    return super.getPrice() + 30.0;
  }
}
