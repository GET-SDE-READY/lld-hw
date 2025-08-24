package designpatterns.RijavLLDJul25.com.designpatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStationRijav implements WeatherSubject {
    private final List<WeatherObserverForRijav> observers = new ArrayList<>();
    private float temperature;
    private float windSpeed;
    private float precipitation;

    public void setMeasurements(float temperature, float windSpeed, float precipitation) {
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.precipitation = precipitation;
        notifyObservers();
    }

    public void addObserver(WeatherObserverForRijav o) {
        observers.add(o);
    }

    public void removeObserver(WeatherObserverForRijav o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (WeatherObserverForRijav o : observers) {
            o.update(temperature, windSpeed, precipitation);
        }
    }
}
