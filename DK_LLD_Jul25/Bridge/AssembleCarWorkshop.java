package designpatterns.DK_LLD_Jul25.Bridge;

public class AssembleCarWorkshop implements Workshop {
    @Override
    public void work() {
        System.out.println("Assemble a car");
    }
}
