import java.util.ArrayList;
import java.util.List;


public class SingletonLogger {

    private LogLevel currentLevel;
    private IFormatter formatter;
    private List<ILogHandler> handlers;
    private  SingletonLogger() {

        this.currentLevel = LogLevel.INFO;
        this.formatter = new SimpleFormatter();
        this.handlers = new ArrayList<>();
        this.handlers.add(new ConsoleHandler()); // default handler
    }


    public void log(LogLevel level, String message) {
        if (level.ordinal() >= currentLevel.ordinal()) {
            String threadName = Thread.currentThread().getName();
            String className = getCallerClassName();

            String formatted = formatter.format(level, message, threadName, className);
            for (ILogHandler handler : handlers) {

                handler.write(formatted);

            }
        }

    }

    // Shorthand methods
    public void debug(String msg) { log(LogLevel.DEBUG, msg); }
    public void info(String msg) { log(LogLevel.INFO, msg); }
    public void warn(String msg) { log(LogLevel.WARN, msg); }
    public void error(String msg) { log(LogLevel.ERROR, msg); }
    public void fatal(String msg) { log(LogLevel.FATAL, msg); }

    // Configuration methods
    public void setLevel(LogLevel level) { this.currentLevel = level; }
    public void setFormatter(IFormatter formatter) { this.formatter = formatter; }
    public void addHandler(ILogHandler handler) { handlers.add(handler); }

    private String getCallerClassName() {
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        // index 3 usually points to the caller (adjust if needed)
        return stack.length > 3 ? stack[3].getClassName() : "Unknown";
    }

    private static class Holder {
        private static final SingletonLogger INSTANCE = new SingletonLogger();
    }

    public static SingletonLogger getInstance() {
        return  Holder.INSTANCE;
    }

}
