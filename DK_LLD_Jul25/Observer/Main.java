package designpatterns.DK_LLD_Jul25.Observer;

import java.util.*;

// Test Main
public class Main { // WeatherStation Observer Demo
    public static void main(String[] args) {
        WeatherStation ws = new WeatherStation();

        // Observers
        PhoneDisplay phone1 = new PhoneDisplay("User1", ws);
        PhoneDisplay phone2 = new PhoneDisplay("User2", ws);
        TVDisplay tv = new TVDisplay(ws);

        // Register observers
        ws.registerObserver(phone1);
        ws.registerObserver(phone2);
        ws.registerObserver(tv);

        System.out.println("---- First Update ----");
        ws.setMeasurements(30.5f, 15.2f, 2.5f);

        System.out.println("---- Second Update ----");
        ws.setMeasurements(28.0f, 20.0f, 5.1f);

        // Remove one observer
        ws.removeObserver(phone2);

        System.out.println("---- Third Update ----");
        ws.setMeasurements(26.7f, 10.5f, 0.0f);
    }
}

/*
Output:
---- First Update ----
User1 Phone Display -> Temp: 30.5°C, Wind: 15.2 km/h, Precipitation: 2.5 mm
User2 Phone Display -> Temp: 30.5°C, Wind: 15.2 km/h, Precipitation: 2.5 mm
TV Display -> Temp: 30.5°C, Wind: 15.2 km/h, Precipitation: 2.5 mm
---- Second Update ----
User1 Phone Display -> Temp: 28.0°C, Wind: 20.0 km/h, Precipitation: 5.1 mm
User2 Phone Display -> Temp: 28.0°C, Wind: 20.0 km/h, Precipitation: 5.1 mm
TV Display -> Temp: 28.0°C, Wind: 20.0 km/h, Precipitation: 5.1 mm
---- Third Update ----
User1 Phone Display -> Temp: 26.7°C, Wind: 10.5 km/h, Precipitation: 0.0 mm
TV Display -> Temp: 26.7°C, Wind: 10.5 km/h, Precipitation: 0.0 mm
 */

// Observer interface
interface Observer {
    void update(); // only notification, no data pushed
}

// Subject interface
interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

// Concrete Subject
class WeatherStation implements Subject {
    private float temperature;     // °C
    private float windSpeed;       // km/h
    private float precipitation;   // mm

    private List<Observer> observers;

    public WeatherStation() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }

    // State change
    public void setMeasurements(float temperature, float windSpeed, float precipitation) {
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.precipitation = precipitation;
        notifyObservers();
    }


    public float getTemperature() {
        return temperature;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public float getPrecipitation() {
        return precipitation;
    }
}

// Concrete Observer 1
class PhoneDisplay implements Observer {
    private WeatherStation weatherStation;
    private String name;

    public PhoneDisplay(String name, WeatherStation ws) {
        this.weatherStation = ws;
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println(name + " Phone Display -> " +
                "Temp: " + weatherStation.getTemperature() + "°C, " +
                "Wind: " + weatherStation.getWindSpeed() + " km/h, " +
                "Precipitation: " + weatherStation.getPrecipitation() + " mm");
    }
}

// Concrete Observer 2
class TVDisplay implements Observer {
    private WeatherStation weatherStation;

    public TVDisplay(WeatherStation ws) {
        this.weatherStation = ws;
    }

    @Override
    public void update() {
        System.out.println("TV Display -> " +
                "Temp: " + weatherStation.getTemperature() + "°C, " +
                "Wind: " + weatherStation.getWindSpeed() + " km/h, " +
                "Precipitation: " + weatherStation.getPrecipitation() + " mm");
    }
}
