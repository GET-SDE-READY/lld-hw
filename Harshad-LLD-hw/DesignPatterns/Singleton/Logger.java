import java.util.List;
import java.util.ArrayList;

public class Logger {

    private List<String> L1;
    private static  Logger instance;


    private Logger () {
        L1 = new ArrayList<>();
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
        }
            }
        }
        return instance;
    }

    public void log(String messages) {
        System.out.println(messages);
        L1.add(messages);
    }

    public List<String> getLogs() {
        return L1;
    }

}
