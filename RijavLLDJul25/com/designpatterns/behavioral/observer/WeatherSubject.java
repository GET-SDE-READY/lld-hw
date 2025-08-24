package designpatterns.RijavLLDJul25.com.designpatterns.behavioral.observer;

public interface WeatherSubject {
    void addObserver(WeatherObserverForRijav o);
    void removeObserver(WeatherObserverForRijav o);
    void notifyObservers();
}
