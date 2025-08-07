package WeatherStationObserverDesignPattern;

/**
 * Subject is the publisher interface.
 */
public interface Subject {
  void addObserver(Display display);
  void notifyAllObservers(WeatherStationMessage weatherStationMessage);
}
