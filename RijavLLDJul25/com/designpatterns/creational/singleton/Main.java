package designpatterns.RijavLLDJul25.com.designpatterns.creational.singleton;

public class Main {
    public static void main(String[] args) {
        Runnable task = () -> {
            AppConfig instance1 = AppConfig.getInstance();
            System.out.println(Thread.currentThread().getName() +
                    ": App - " + instance1.getAppName() +
                    ", Version - " + instance1.getVersion());

            // creating second instance
            AppConfig instance2 = AppConfig.getInstance();
            System.out.println("Are instance same? " + (instance2 == instance1));
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        Thread t3 = new Thread(task, "Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }
}
