package DecoratorDesignPattern;

public class CoffeeMain {

  public static void main(String[] args) {
    CoffeeService baseCoffee = new BaseCoffee();
    System.out.println("Base Coffee name: " + baseCoffee.getName());
    System.out.println("Base Coffee price: " + baseCoffee.getPrice());

    CoffeeDecorator addedMilk = new MilkDecorator(baseCoffee);
    System.out.println("Added milk: " + addedMilk.getName());
    System.out.println("Added milk price: " + addedMilk.getPrice());

    CoffeeDecorator addedSugar = new SugarDecorator(baseCoffee);
    System.out.println("Added sugar: " + addedSugar.getName());
    System.out.println("Added sugar price: " + addedSugar.getPrice());

    CoffeeDecorator addedCream = new CreamDecorator(baseCoffee);
    System.out.println("Added cream: " + addedCream.getName());
    System.out.println("Added cream price: " + addedCream.getPrice());

  }

}
