package WeatherStationObserverDesignPattern;

import java.text.MessageFormat;

public class CurrentConditionsDisplay implements Display {

  private double currentTemperature;
  private double currentHumidity;

  @Override
  public void update(WeatherStationMessage weatherStationMessage) {
    this.currentTemperature = weatherStationMessage.getTemperature();
    this.currentHumidity = weatherStationMessage.getHumidity();
  }

  @Override
  public String display() {
    return MessageFormat.format("Current conditions: {0}°C and {1}% humidity.",
        currentTemperature, currentHumidity);
  }
}
