package designpatterns.designpatterns.ankush_LLD_Aug.SingletonLogger;

public class Driver {
    public static void main(String[] args) {
        Logger logger1 = Logger.getLogger();
        Logger logger2 = Logger.getLogger();
        logger1.info("Logging first log using instance --> " + logger1);
        logger2.info("Logging second log using instance --> " + logger2);
    }
}
