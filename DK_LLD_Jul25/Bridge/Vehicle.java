package designpatterns.DK_LLD_Jul25.Bridge;

// Abstraction
public abstract class Vehicle {

    protected Workshop manufacturingWorkshop;
    protected Workshop assemblyWorkshop;

    protected Vehicle(Workshop manufacturingWorkshop, Workshop assemblyWorkshop) {
        this.manufacturingWorkshop = manufacturingWorkshop;
        this.assemblyWorkshop = assemblyWorkshop;
    }

    abstract public void create();
}
