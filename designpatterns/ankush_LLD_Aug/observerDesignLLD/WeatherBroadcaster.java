package designpatterns.designpatterns.ankush_LLD_Aug.observerDesignLLD;

import java.util.ArrayList;
import java.util.List;

public class WeatherBroadcaster implements Producer{
    List<Observer> observers;

    public WeatherBroadcaster() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserverr(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
      observers.remove(observer);
    }

    @Override
    public void notifyAllObserverss(List<Observer> observerList, WeatherInfo weatherInfo) {
      observerList.stream().forEach(observer -> observer.updateInfo(weatherInfo));
    }

    @Override
    public void updateWeatherInfo(WeatherInfo weatherInfo) {
       notifyAllObserverss(observers,weatherInfo);
    }
}
