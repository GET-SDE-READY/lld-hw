import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SimpleFormatter implements IFormatter {
    @Override
    public String format(LogLevel level, String message , String threadName, String className) {
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String thread = Thread.currentThread().getName();
        return String.format("[%s] %s (%s) [%s] : %s", timestamp, level, thread, className, message);
    }
}
