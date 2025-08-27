public class Driver {
    public static void main(String[] args) {
        SingletonLogger logger = SingletonLogger.getInstance();

        // Configure logger: DEBUG level, JSON format, Console + File outputs
        logger.setLevel(LogLevel.DEBUG);
        logger.setFormatter(new SimpleFormatter());
      //  logger.addHandler(new ConsoleHandler()); by default its there
        logger.addHandler(new FileHandler("app.log"));

        // Log some messages
        logger.info("Application started \" ");
        logger.debug("Processing data...");
        logger.error("An error occurred");

        // Change level at runtime (e.g., for troubleshooting)
        logger.setLevel(LogLevel.ERROR);
        logger.info("This message will not be logged (level too low)");
        logger.error("This error will still be logged");
    }
}
