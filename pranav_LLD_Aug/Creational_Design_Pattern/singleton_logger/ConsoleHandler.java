public class ConsoleHandler implements ILogHandler{
    @Override
    public void write(String message) {
        System.out.println(message);
    }
}
