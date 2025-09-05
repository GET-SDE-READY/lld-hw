public interface IFormatter {
    String format(LogLevel level, String message, String threadName, String className);

   // String format(LogLevel level, String message);
}
