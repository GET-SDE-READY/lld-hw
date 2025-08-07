public class BurgerFactoryApplication {
    public static void main(String[] args) {
        BurgerFactory burgerFactory = new BurgerFactory();
        Burger burger = burgerFactory.createBurger("Maharaja");
        Burger addCheese = new Cheese(burger);
        Burger addTikki = new Tikki(addCheese);
        burger.displayMessage();
        addCheese.displayMessage();
        addTikki.displayMessage();
        System.out.println("Price of burger is "+addTikki.getPrice());

    }
}


class BurgerFactory {
    public Burger createBurger(String burger){
        SimpleBurger simpleBurger= new SimpleBurger();
        if(burger==null || burger.isEmpty()) return null;
        return switch (burger) {
            case "Maharaja" -> new MaharajaBurger(simpleBurger);
            case "Chicker" -> new ChickenBurger(simpleBurger);
            case "MacAlooTikki" -> new MacAlooTikkiBurger(simpleBurger);
            case "Cheese" -> new CheeseBurger(simpleBurger);
            default -> throw new IllegalArgumentException("Unknow Burger" + burger);
        };

    }
}

interface Burger {
    double getPrice();
    void displayMessage();
}

class SimpleBurger implements Burger{

    @Override
    public double getPrice() {
        return 2.0;
    }

    @Override
    public void displayMessage() {
        System.out.println("This is simpleBurger");
    }
}


abstract class BurgerDecorater implements Burger{
    private Burger burger;
    public BurgerDecorater(Burger burger) {
        this.burger = burger;
    }
    @Override
    public double getPrice() {
        return burger.getPrice();
    }

    @Override
    public void displayMessage() {
        burger.displayMessage();
    }
}



class CheeseBurger extends BurgerDecorater {
    public CheeseBurger(Burger burger) {
        super(burger);
    }

    @Override
    public double getPrice() {
        return super.getPrice()+ 5.0;
    }

    @Override
    public void displayMessage() {
        System.out.println("This is rich cheese burger");
    }
}

class ChickenBurger extends BurgerDecorater{
    public ChickenBurger(Burger burger) {
        super(burger);
    }

    @Override
    public double getPrice() {
        return super.getPrice()+ 10.0;
    }

    @Override
    public void displayMessage() {
        System.out.println("This is delicious Chicken Burger");
    }
}

class MacAlooTikkiBurger extends BurgerDecorater{
    public MacAlooTikkiBurger(Burger burger) {
        super(burger);
    }

    @Override
    public double getPrice() {
        return super.getPrice()+ 3.0;
    }

    @Override
    public void displayMessage() {
        System.out.println("This is Best Seller Mac Aloo tickki");
    }
}

class MaharajaBurger extends BurgerDecorater{
    public MaharajaBurger(Burger burger) {
        super(burger);
    }

    @Override
    public double getPrice() {
        return super.getPrice()+ 7.0;
    }

    @Override
    public void displayMessage() {
        System.out.println("This is great Maharaja Burger");
    }
}

class Tikki extends BurgerDecorater {
    public Tikki(Burger burger) {
        super(burger);
    }

    @Override
    public double getPrice() {
        return super.getPrice()+ 1.0;
    }

    @Override
    public void displayMessage() {
        System.out.println("Adding extra Tikki");
    }
}

class Cheese extends BurgerDecorater {
    public Cheese(Burger burger) {
        super(burger);
    }

    @Override
    public double getPrice() {
        return super.getPrice()+ 1.5;
    }

    @Override
    public void displayMessage() {
        System.out.println("Adding extra Cheese");
    }
}


