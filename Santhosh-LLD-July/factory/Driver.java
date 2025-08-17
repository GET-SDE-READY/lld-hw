public class Driver {
	public static void main(String[] args) {

		System.out.println(PizzaFactory.getPizza("VEG").getName());
		System.out.println(PizzaFactory.getPizza("CHICKEN").getName());
	}
}

interface Pizza {
	public String getName();
}

class VegPizza implements Pizza {
	public String getName() {
		return "Veg Pizza";
	}

}

class ChickenPizza implements Pizza {
	public String getName() {
		return "Chicken Pizza";
	}

}

class PizzaFactory {

	public static Pizza getPizza(String type) {
		if (type.equals("VEG")) {
			return new VegPizza();
		}
		if (type.equals("CHICKEN")) {
			return new ChickenPizza();
		}
		return new ChickenPizza();
	}
}