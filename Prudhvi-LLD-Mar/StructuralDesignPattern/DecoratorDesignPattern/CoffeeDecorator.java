package DecoratorDesignPattern;

public abstract class CoffeeDecorator {
  private CoffeeService coffeeService;

  public CoffeeDecorator(CoffeeService coffeeService) {
    this.coffeeService = coffeeService;

  }

  public String getName() {
    return coffeeService.getName();
  }

  public Double getPrice() {
    return coffeeService.getPrice();
  }

}
