package designpatterns.DK_LLD_Jul25.Bridge;

public class ManufactureBikeWorkshop implements Workshop {
    @Override
    public void work() {
        System.out.println("Manufacture a bike");
    }
}
