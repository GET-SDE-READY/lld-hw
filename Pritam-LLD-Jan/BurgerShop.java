import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 class BurgerShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Item> order = new ArrayList<>();

        System.out.println("Welcome to the Burger Shop!");

        while (true) {
            System.out.println("Choose a menu item (burger/fries/done):");
            String menuItem = scanner.nextLine().trim();

            if (menuItem.equalsIgnoreCase("done")) {
                break;
            }

            if (menuItem.equalsIgnoreCase("burger")) {
                System.out.println("Choose a burger type(cheese/veggie/tikki):");
                String burgerType = scanner.nextLine().trim();
                Burger burger = ItemFactory.createBurger(burgerType);
                order.add(burger);

                System.out.println("Do you want to add condiments? (yes/no)");
                String addCondiments = scanner.nextLine().trim();

                while (addCondiments.equalsIgnoreCase("yes")) {
                    System.out.println("Choose a condiment to add(cheese/veggie/tikki):");
                    String condimentType = scanner.nextLine().trim();
                    burger = ItemFactory.createBurger(condimentType);
                    order.add(burger);

                    System.out.println("Do you want to add more condiments? (yes/no)");
                    addCondiments = scanner.nextLine().trim();
                }
            } else if (menuItem.equalsIgnoreCase("fries")) {
                System.out.println("Choose a fries topping(cheese/chilli):");
                String friesType = scanner.nextLine().trim();
                Fries fries = ItemFactory.createFries(friesType);
                order.add(fries);
            }
        }

        double totalPrice = 0;
        System.out.println("\nYour order details:");

        for (Item item : order) {
            System.out.println(item.getDescription() + " - $" + item.getPrice());
            totalPrice += item.getPrice();
        }

        System.out.println("\nTotal Price: $" + totalPrice);
        System.out.println("Thank you for ordering!");
    }
}
// Interface for items (Burger, Fries)
interface Item {
    double getPrice();
    String getDescription();
}

// Interface for the Burger
interface Burger extends Item {
}

// Concrete implementation of a basic Burger
class BasicBurger implements Burger {
    @Override
    public double getPrice() {
        return 5.0;
    }

    @Override
    public String getDescription() {
        return "Basic Burger";
    }
}

// Decorator pattern for adding condiments
abstract class CondimentDecorator implements Burger {
    protected Burger burger;

    public CondimentDecorator(Burger burger) {
        this.burger = burger;
    }

    @Override
    public double getPrice() {
        return burger.getPrice();
    }

    @Override
    public String getDescription() {
        return burger.getDescription();
    }
}

// Concrete condiments
class Cheese extends CondimentDecorator {
    public Cheese(Burger burger) {
        super(burger);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 1.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Cheese";
    }
}

class Veggie extends CondimentDecorator {
    public Veggie(Burger burger) {
        super(burger);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 0.5;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Veggie";
    }
}

class Tikki extends CondimentDecorator {
    public Tikki(Burger burger) {
        super(burger);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 1.5;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Tikki";
    }
}

// Interface for the Fries
interface Fries extends Item {
}

// Concrete implementation of basic Fries
class BasicFries implements Fries {
    @Override
    public double getPrice() {
        return 3.0;
    }

    @Override
    public String getDescription() {
        return "Basic Fries";
    }
}

// Decorator pattern for adding toppings to Fries
abstract class ToppingDecorator implements Fries {
    protected Fries fries;

    public ToppingDecorator(Fries fries) {
        this.fries = fries;
    }

    @Override
    public double getPrice() {
        return fries.getPrice();
    }

    @Override
    public String getDescription() {
        return fries.getDescription();
    }
}

// Concrete toppings for Fries
class CheeseTopping extends ToppingDecorator {
    public CheeseTopping(Fries fries) {
        super(fries);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 1.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Cheese Topping";
    }
}

class ChiliTopping extends ToppingDecorator {
    public ChiliTopping(Fries fries) {
        super(fries);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 1.5;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Chili Topping";
    }
}

// Factory pattern for creating burgers and fries
class ItemFactory {
    public static Burger createBurger(String type) {
        Burger burger = new BasicBurger();

        switch (type.toLowerCase()) {
            case "cheese":
                burger = new Cheese(burger);
                break;
            case "veggie":
                burger = new Veggie(burger);
                break;
            case "tikki":
                burger = new Tikki(burger);
                break;
        }

        return burger;
    }

    public static Fries createFries(String type) {
        Fries fries = new BasicFries();

        switch (type.toLowerCase()) {
            case "cheese":
                fries = new CheeseTopping(fries);
                break;
            case "chili":
                fries = new ChiliTopping(fries);
                break;
        }

        return fries;
    }
}


