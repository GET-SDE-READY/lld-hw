package designpatterns.DK_LLD_Jul25.Bridge;

// refined abstraction
public class ManufactureCarWorkshop implements Workshop {
    @Override
    public void work() {
        System.out.println("Manufacture a Car");
    }
}
