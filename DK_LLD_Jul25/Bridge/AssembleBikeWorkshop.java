package designpatterns.DK_LLD_Jul25.Bridge;

public class AssembleBikeWorkshop implements Workshop {
    @Override
    public void work() {
        System.out.println("Assemble a bike");
    }
}
