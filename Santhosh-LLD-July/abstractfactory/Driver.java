

interface IPizza {
	public String getName();
}

class VegPizza implements IPizza {
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "VEG PIZZA FROM DOMINOS";
	}
}

class ChickenPizza implements IPizza {
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Chicken PIZZA FROM DOMINOS";
	}
}

interface IPizzaFactory {
	IPizza getPizza(String type);
}

class DomionsPizzaFactory implements IPizzaFactory{

	@Override
	public IPizza getPizza(String type) {
		// TODO Auto-generated method stub
		if(type.equals("VEG")) {
			System.out.println("ordered from DOMINOS");
			return new VegPizza();
		}
		else {
			System.out.println("ordered from DOMINOS");
			return new ChickenPizza();
		}
	}
	
}
class PizzaHutFactory implements IPizzaFactory{

	@Override
	public IPizza getPizza(String type) {
		// TODO Auto-generated method stub
		if(type.equals("VEG")) {
			System.out.println("ordered from PizzaHut");
			return new VegPizza();
		}
		else {
			System.out.println("ordered from PizzaHut");
			return new ChickenPizza();
		}
	}
	
}

class FactoryProvider {
	
	public static IPizzaFactory getFactory(String type) {
		if(type.equals("DOMIONS")) {
			return new DomionsPizzaFactory();
		}
		else {
			return new PizzaHutFactory();
		}
	}
}

public class Driver {
	public static void main(String[] args) {
		
		IPizzaFactory dominosFactory = FactoryProvider.getFactory("DOMIONS");
		IPizzaFactory pizzaHutFactory = FactoryProvider.getFactory("PIZZAHUT");
		
		dominosFactory.getPizza("VEG");
		pizzaHutFactory.getPizza("CHICKEN");
	}
}
