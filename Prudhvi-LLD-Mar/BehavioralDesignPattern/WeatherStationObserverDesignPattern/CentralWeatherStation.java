package WeatherStationObserverDesignPattern;

public class CentralWeatherStation {

  public static void main(String[] args) {
    CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay();
    StatisticsDisplay statisticsDisplay = new StatisticsDisplay();

    Subject subject = new WeatherStation();
    subject.addObserver(currentConditionsDisplay);
    subject.addObserver(statisticsDisplay);

    subject.notifyAllObservers(new WeatherStationMessage(25.0, 65, 30));
    System.out.println(currentConditionsDisplay.display());
    System.out.println(statisticsDisplay.display());

    System.out.println();
    subject.notifyAllObservers(new WeatherStationMessage(35.0, 75, 30));
    System.out.println(currentConditionsDisplay.display());
    System.out.println(statisticsDisplay.display());
  }

}
