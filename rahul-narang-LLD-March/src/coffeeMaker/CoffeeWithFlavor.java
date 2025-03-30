package coffeeMaker;

class CoffeeWithFlavor extends CoffeeDecorator {

    public CoffeeWithFlavor(Coffee coffee, String name, Double cost) {
        super(coffee," with " + name + " flavor", cost);
    }
}