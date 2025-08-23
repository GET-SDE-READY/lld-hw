package designpatterns.designpatterns.ankush_LLD_Aug.SingletonLogger;

public class Logger {
private static volatile Logger logger;

private Logger(){
    System.out.println("Logger class initalized");
}

public static synchronized Logger getLogger(){
    if(logger == null){
        logger = new Logger();
    }
    return logger;
}

public void info(String log){
    System.out.println(log);
}

}
