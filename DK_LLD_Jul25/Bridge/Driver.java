package designpatterns.DK_LLD_Jul25.Bridge;

// Implementer
public class Driver {

    public static void main(String[] args) {
        Vehicle car = new Car(new ManufactureCarWorkshop(), new AssembleCarWorkshop());
        car.create();
        //output:
        // "We are creating car"
        // "Manufacture a car"
        // "Assemble a car"

        // HW
        // Extend it for bike
        Vehicle bike = new Bike(new ManufactureBikeWorkshop(), new AssembleBikeWorkshop());
        bike.create();
        //output:
        // "We are creating bike"
        // "Manufacture a bike"
        // "Assemble a bike"

    }
}
