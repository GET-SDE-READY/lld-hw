package DecoratorDesignPattern;

public class CreamDecorator extends CoffeeDecorator{

  public CreamDecorator(CoffeeService coffeeService) {
    super(coffeeService);
  }

  public String getName() {
    return super.getName().concat(", added cream");
  }

  public Double getPrice() {
    return super.getPrice() + 100.0;
  }
}
