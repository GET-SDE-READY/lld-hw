package DecoratorDesignPattern;

public class BaseCoffee implements CoffeeService {

  @Override
  public String getName() {
    return "Base coffee";
  }

  @Override
  public Double getPrice() {
    return 10.0;
  }
}
