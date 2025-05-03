package WeatherStationObserverDesignPattern;


import java.text.MessageFormat;

public class StatisticsDisplay implements Display {

  private double currentTemperature;
  private double currentHumidity;

  @Override
  public void update(WeatherStationMessage weatherStationMessage) {
    this.currentTemperature = weatherStationMessage.getTemperature();
    this.currentHumidity = weatherStationMessage.getHumidity();
  }

  @Override
  public String display() {
    return MessageFormat.format("Statistics: Temperature: {0}°C, Humidity: {1}%",
        currentTemperature, currentHumidity);
  }
}
