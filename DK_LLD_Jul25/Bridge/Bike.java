package designpatterns.DK_LLD_Jul25.Bridge;

public class Bike extends Vehicle {
    protected Bike(Workshop manufacturingWorkshop, Workshop assemblyWorkshop) {
        super(manufacturingWorkshop, assemblyWorkshop);
    }

    @Override
    public void create() {
        System.out.println("We are creating bike");
        manufacturingWorkshop.work();
        assemblyWorkshop.work();
    }
}
