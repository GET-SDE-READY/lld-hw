package designpatterns;

public class CoffeMakerGetSDE {

	
	public static void main(String[] args) {
		BaseCoffee baseCoffee = new BaseCoffee();
		CoffeeDecorator coffeeDecorator = new WhippedCream(baseCoffee);
		System.out.println(coffeeDecorator.getName() + " "+coffeeDecorator.getCost()+" " );
		CoffeeDecorator coffeeDecorator2 = new ChocoFLavours(coffeeDecorator);
		System.out.println(coffeeDecorator2.getName() + " "+coffeeDecorator2.getCost()+" ");
	}
}

interface Coffee{
	String getName();
	Double getCost();
}

class BaseCoffee implements Coffee{
	String name = "Base Coffee";
	Double cost = 10.0;
	public String getName() {
		return this.name;
	}
	public Double getCost() {
		return this.cost;
	}
	
}

abstract class CoffeeDecorator implements Coffee{
	protected Coffee coffee;
	protected String name;
	protected Double cost;
	public CoffeeDecorator(Coffee coffee,String name,Double cost) {
		this.coffee=coffee;
		this.name=name;
		this.cost = cost;
		
	}
	
	public String getName() {
		return this.coffee.getName() +"->"+ this.name;
	}
	public Double getCost() {
		return this.cost + this.coffee.getCost();
	}
}

class WhippedCream extends CoffeeDecorator{
	public WhippedCream(Coffee coffee) {
		super(coffee,"Coffee with whipped Cream",5.0);
		
	}
}

class ChocoFLavours extends CoffeeDecorator{
	public ChocoFLavours(Coffee coffee) {
		super(coffee,"Coffee with Chocolate Flavour",8.0);
		
	}
}


