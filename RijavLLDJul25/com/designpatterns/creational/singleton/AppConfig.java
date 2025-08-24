package designpatterns.RijavLLDJul25.com.designpatterns.creational.singleton;

public class AppConfig {
    private static volatile AppConfig instance;
    private final String appName;
    private final String version;

    private AppConfig() {
        this.appName = "App-Test";
        this.version = "0.0.1";
        System.out.println("App instance created");
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            synchronized (AppConfig.class) { // ensuring thread safety
                if (instance == null) {
                    instance = new AppConfig();
                }
            }
        }
        return instance;
    }

    public String getAppName() {
        return appName;
    }

    public String getVersion() {
        return version;
    }
}
