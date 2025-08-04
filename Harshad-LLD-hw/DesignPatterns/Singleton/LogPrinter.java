import java.util.List;

public class LogPrinter {
    public void printLog(List<String> logs) {
        System.out.println("---- Printing Order ----");
        for (String log : logs) {
            System.out.println(log);
        }
    }
}
