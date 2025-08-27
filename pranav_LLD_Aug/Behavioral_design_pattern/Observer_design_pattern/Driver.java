public class Driver {

    public static void main(String[] args) {


        WeatherStation weatherStation = new WeatherStation();

        IObserver windSpeedObserver = new WindSpeedObserver();
        IObserver temperatureObserver =  new TemperatureObserver();
        IObserver precipitationObserver =  new PrecipitationObserver();

        weatherStation.addObserver(windSpeedObserver);
        weatherStation.addObserver(temperatureObserver);
        weatherStation.addObserver(precipitationObserver);

        // started notifying
        weatherStation.notifyObservers(new WeatherEvent(10, 25, 1200));
        weatherStation.display();

        weatherStation.notifyObservers(new WeatherEvent(100, 29, 1100));
        weatherStation.display();

        weatherStation.notifyObservers(new WeatherEvent(106, 21, 1000));
        weatherStation.display();

        weatherStation.notifyObservers(new WeatherEvent(40, 23, 900));
        weatherStation.display();
    }
}
