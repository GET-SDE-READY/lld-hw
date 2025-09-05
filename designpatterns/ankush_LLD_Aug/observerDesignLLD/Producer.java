package designpatterns.designpatterns.ankush_LLD_Aug.observerDesignLLD;

import java.util.List;

public interface Producer {

    public void addObserverr(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyAllObserverss(List<Observer> observerList, WeatherInfo weatherInfo);
    public void updateWeatherInfo(WeatherInfo weatherInfo);
}
