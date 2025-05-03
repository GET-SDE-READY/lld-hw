package WeatherStationObserverDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject {

  private List<Display> displays;

  public WeatherStation() {
    this.displays = new ArrayList<>();
  }

  @Override
  public void addObserver(Display display) {
    displays.add(display);
  }

  @Override
  public void notifyAllObservers(WeatherStationMessage weatherStationMessage) {
    for (Display display : displays) {
      display.update(weatherStationMessage);
    }
  }
}
