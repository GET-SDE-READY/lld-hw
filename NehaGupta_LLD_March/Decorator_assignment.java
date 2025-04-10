package Structural;

public class Coffee_Assignment {
    public static void main(String[] args) {
        Coffee coffee=new plainCoffee();
        Coffee whippedCreamcoffee=new whipped_cream(coffee);
        Coffee flavours=new flavours(coffee);
        System.out.println(whippedCreamcoffee.getName() +" cost "+whippedCreamcoffee.getCost());
        System.out.println(flavours.getName()+" Cost "+flavours.getCost());
    }
}
interface Coffee{
    String getName();
    Double getCost();
}
class plainCoffee implements  Coffee{
    String name="Black";
    Double cost=100.0;
    public String getName(){
        return name;
    }
    public Double getCost(){
        return cost;
    }

}

abstract class coffeeDecorator implements Coffee{
    protected Coffee coffee;
    protected String name;
    protected Double cost;
    public coffeeDecorator(Coffee coffee,String name,Double cost){
        this.coffee=coffee;
        this.name=name;
        this.cost=cost;
    }
    public String getName(){
        return String.format("%s %s",this.coffee.getName(),this.name);
    }
    public  Double getCost(){
        return this.cost+coffee.getCost();
    }
}
class whipped_cream extends coffeeDecorator{

    public whipped_cream(Coffee coffee) {
        super(coffee,"Whipped",60.0);
    }
}
class flavours extends coffeeDecorator{

    public flavours(Coffee coffee) {
        super(coffee,"Flavoured",75.0);
    }
}
