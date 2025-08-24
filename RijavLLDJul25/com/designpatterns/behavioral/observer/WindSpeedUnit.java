package designpatterns.RijavLLDJul25.com.designpatterns.behavioral.observer;

public class WindSpeedUnit implements WeatherObserverForRijav {

    @Override
    public void update(float temperature, float windSpeed, float precipitation) {
        System.out.println("Wind Unit: Current Wind Speed = " + windSpeed + " km/h");
    }
}
