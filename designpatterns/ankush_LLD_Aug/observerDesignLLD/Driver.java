package designpatterns.designpatterns.ankush_LLD_Aug.observerDesignLLD;

public class Driver {
    public static void main(String[] args) {
        Producer weatherBroadcaster = new WeatherBroadcaster();
        weatherBroadcaster.addObserverr(new WindSpeedUi());
        weatherBroadcaster.addObserverr(new TemperatureUI());
        weatherBroadcaster.addObserverr(new PrecipitationUI());
        WeatherInfo weatherInfo = new WeatherInfo("25 Degree","1000 pp","50 kmph");
        weatherBroadcaster.updateWeatherInfo(weatherInfo);
    }
}
