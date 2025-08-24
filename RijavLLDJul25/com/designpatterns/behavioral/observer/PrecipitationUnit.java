package designpatterns.RijavLLDJul25.com.designpatterns.behavioral.observer;

public class PrecipitationUnit implements WeatherObserverForRijav {

    @Override
    public void update(float temperature, float windSpeed, float precipitation) {
        System.out.println("Precipitation Unit: Current Precipitation = " + precipitation + " mm");
    }
}
