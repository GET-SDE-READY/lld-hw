package coffeeMaker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CoffeeMakerTest {

    private Coffee baseCoffee;
    private Coffee coffeeWithWhippedCream;

    /**
     * @Before → JUnit 4 annotation (won't be executed in JUnit 5).
     *
     * @BeforeEach → JUnit 5 annotation (replaces @Before).
     */

    @BeforeEach
    public void setup() {
        baseCoffee = new BaseCoffee();
        coffeeWithWhippedCream = new CoffeeWithWhippedCream(baseCoffee);
    }

    @Test
    public void testPlainCoffee() {
        assertEquals("Plain Coffee", baseCoffee.getName());
        assertEquals(45.0, baseCoffee.getCost());
    }

    @Test
    public void testCoffeeWithWhippedCream() {
        assertEquals("Plain Coffee with whipped cream", coffeeWithWhippedCream.getName());
        assertEquals(55.0, coffeeWithWhippedCream.getCost());
    }

    @Test
    public void testCoffeeWithCaramelFlavor() {
        Coffee coffee = new CoffeeWithFlavor(baseCoffee, FlavorType.CARAMEL.getFlavor(), FlavorType.CARAMEL.getCost());
        assertEquals("Plain Coffee with Caramel flavor", coffee.getName());
        assertEquals(68.0, coffee.getCost());
    }

    @Test
    public void testCoffeeWithWhippedCreamAndVanillaFlavor() {
        Coffee coffee = new CoffeeWithFlavor(coffeeWithWhippedCream, FlavorType.VANILLA.getFlavor(), FlavorType.VANILLA.getCost());
        assertEquals("Plain Coffee with whipped cream with Vanilla flavor", coffee.getName());
        assertEquals(81.0, coffee.getCost());
    }

    @Test
    public void testCoffeeWithHazelnutFlavor() {
        Coffee coffee = new CoffeeWithFlavor(baseCoffee, FlavorType.HAZELNUT.getFlavor(), FlavorType.HAZELNUT.getCost());
        assertEquals("Plain Coffee with Hazelnut flavor", coffee.getName());
        assertEquals(75.0, coffee.getCost());
    }
}
