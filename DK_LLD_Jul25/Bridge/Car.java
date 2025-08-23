package designpatterns.DK_LLD_Jul25.Bridge;

// Refined Abstraction
public class Car extends Vehicle {

    protected Car(Workshop manufacturingWorkshop, Workshop assemblyWorkshop) {
        super(manufacturingWorkshop, assemblyWorkshop);
    }

    @Override
    public void create() {
        System.out.println("We are creating a Car");
        manufacturingWorkshop.work();
        assemblyWorkshop.work();
    }
}
