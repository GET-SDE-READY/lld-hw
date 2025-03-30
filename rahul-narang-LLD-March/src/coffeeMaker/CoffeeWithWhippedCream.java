package coffeeMaker;

class CoffeeWithWhippedCream extends CoffeeDecorator {
    /**
     * When you define a class that extends another class, the child class constructor implicitly calls the default
     * constructor of the parent class (if you don't explicitly specify which constructor to use).
     * In this code, Since CoffeeDecorator does not have a default constructor, Java expects you to call the parameterized
     * constructor explicitly using super
     */

    public CoffeeWithWhippedCream(Coffee coffee) {
        super(coffee, " with whipped cream", 10.0);
    }
}