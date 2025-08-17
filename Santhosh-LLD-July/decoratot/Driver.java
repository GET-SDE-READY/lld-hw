

public class Driver {
	// coffee
	// simple coffee
	// with milk, sugar etc
	public static void main(String[] args) {
		
		Coffee simpleCoffee = new SimpleCoffee();
		System.out.println(simpleCoffee.getDescription());
		
		
		Coffee milkSugaarCoffee = new SugarDecorator(new MilkDecorator(simpleCoffee));
		
		System.out.println(milkSugaarCoffee.getDescription());
		System.out.println(milkSugaarCoffee.getPrice());
	}

}

interface Coffee {

	String getDescription();

	double getPrice();
}

class SimpleCoffee implements Coffee {

	@Override
	public String getDescription() {
		return "Simple Coffee";
	}

	@Override
	public double getPrice() {
		return 100.0;
	}
}

abstract class CoffeeDecorator implements Coffee {
	Coffee coffee;

	CoffeeDecorator(Coffee coffee) {
		this.coffee = coffee;
	}

	public String getDescription() {
		return coffee.getDescription();
	}

	public double getPrice() {
		return coffee.getPrice();
	}

}


class MilkDecorator extends CoffeeDecorator{

	MilkDecorator(Coffee coffee) {
		super(coffee);
	}
	
	public String getDescription() {
		return "Milk " + coffee.getDescription();
	}

	public double getPrice() {
		return 10.2 + coffee.getPrice();
	}
}

class SugarDecorator extends CoffeeDecorator{

	SugarDecorator(Coffee coffee) {
		super(coffee);
	}
	
	public String getDescription() {
		return "Sugar " + coffee.getDescription();
	}

	public double getPrice() {
		return 10.3 + coffee.getPrice();
	}
}