package designpatterns.RijavLLDJul25.com.designpatterns.behavioral.observer;

public class TemperatureUnit implements WeatherObserverForRijav {

    @Override
    public void update(float temperature, float windSpeed, float precipitation) {
        System.out.println("Temperature Unit: Current Temperature = " + temperature + "°C");
    }
}
