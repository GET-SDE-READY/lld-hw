package Design_Patterns.Behavioral.WeatherStation;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Observable {

	private Weather weather;

	List<Observer> observers;

	public WeatherStation() {
		this.weather = new Weather();
		this.observers = new ArrayList<Observer>();
	}

	@Override
	public void addObservers(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObservers(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifySubscribedObservers() {
		observers.forEach(o -> o.update(this.weather));
	}

	public void weatherstatechanged(int temperature, int humidity, int aqi, boolean rainfall) {
		this.weather.setTemperature(temperature);
		this.weather.setHumidity(humidity);
		this.weather.setAqi(aqi);
		this.weather.setRainfall(rainfall);
		notifySubscribedObservers();

	}

}
