package WeatherStationObserverDesignPattern;

/**
 * Interface with all display observer methods. (subscriber)
 */
public interface Display {
  void update(WeatherStationMessage weatherStationMessage);
  String display();
}
