package designpatterns.RijavLLDJul25.com.designpatterns.behavioral.observer;

public class WeatherStationDemo {
    public static void main(String[] args) {
        WeatherStationRijav station = new WeatherStationRijav();

        WeatherObserverForRijav tempUnit = new TemperatureUnit();
        WeatherObserverForRijav windUnit = new WindSpeedUnit();
        WeatherObserverForRijav precipitationUnit = new PrecipitationUnit();

        station.addObserver(tempUnit);
        station.addObserver(windUnit);
        station.addObserver(precipitationUnit);

        System.out.println("--- First Update ---");
        station.setMeasurements(25.5f, 12.3f, 4.0f);

        System.out.println("\n--- Second Update ---");
        station.setMeasurements(30.2f, 8.5f, 0.0f);

        station.removeObserver(precipitationUnit);
        station.removeObserver(windUnit);
        station.removeObserver(tempUnit);
    }
}
