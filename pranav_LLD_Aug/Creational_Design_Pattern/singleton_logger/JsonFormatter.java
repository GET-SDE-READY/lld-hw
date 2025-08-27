import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JsonFormatter implements IFormatter {

    @Override
    public String format(LogLevel level, String message, String threadName, String className) {
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String thread = Thread.currentThread().getName();

        return String.format(
                "{ \"timestamp\": \"%s\", \"level\": \"%s\", \"thread\": \"%s\", \"class\": \"%s\", \"message\": \"%s\" }",
                timestamp, level, threadName, className, message
        );
    }


}
