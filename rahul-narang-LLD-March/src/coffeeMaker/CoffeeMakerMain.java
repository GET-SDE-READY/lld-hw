package coffeeMaker;

public class CoffeeMakerMain {
    public static void main(String[] args) {
        Coffee baseCoffee = new BaseCoffee();

        Coffee coffeeWithWhippedCream = new CoffeeWithWhippedCream(baseCoffee);

        Coffee coffeeWithCaramelFlavor =
                new CoffeeWithFlavor(baseCoffee, FlavorType.CARAMEL.getFlavor(), FlavorType.CARAMEL.getCost());

        Coffee coffeeWithWhippedCreamAndVanillaFlavor =
                new CoffeeWithFlavor(coffeeWithWhippedCream, FlavorType.VANILLA.getFlavor(), FlavorType.VANILLA.getCost());

        System.out.printf("%s: %s%n", baseCoffee.getName(), baseCoffee.getCost());
        System.out.printf("%s: %s%n", coffeeWithWhippedCream.getName(), coffeeWithWhippedCream.getCost());
        System.out.printf("%s: %s%n", coffeeWithCaramelFlavor.getName(), coffeeWithCaramelFlavor.getCost());
        System.out.printf("%s: %s%n", coffeeWithWhippedCreamAndVanillaFlavor.getName(), coffeeWithWhippedCreamAndVanillaFlavor.getCost());
    }

    /*
    Output:

        Plain Coffee: 45.0
        Plain Coffee with whipped cream: 55.0
        Plain Coffee with Caramel flavor: 68.0
        Plain Coffee with whipped cream with Vanilla flavor: 81.0

        Process finished with exit code 0
     */
}

