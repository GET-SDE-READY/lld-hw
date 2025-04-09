package designpatterns;

import java.util.ArrayList;
import java.util.List;

public class WeatherStationGetSDE {

	
	public static void main(String[] args) {
		WeatherStation station = new WeatherStation();
		Observer currentDis = new CurrentConditionsDisplay();
		Observer staObserver = new StatisticsDisplay();
		station.addObserver(currentDis);
		station.addObserver(staObserver);

		
	station.set(0.3f, 12, 0.457f);
	}
}


// observer
interface Observer{
	void update(float temprature,int humidity,float pressure);
}


interface Subject{
	void addObserver(Observer o);
	void deleteObserver(Observer o);
	void notifyObservers();
}

class WeatherStation implements Subject{
	private float temprature;
	private int hum;
	private float pre;
	
	private List<Observer> observers = new ArrayList<Observer>();
	
	public void set(float temp,int hum,float pre) {
		this.temprature = temp;
		this.hum=hum;
		this.pre = pre;
		notifyObservers();
	}
	
	
	@Override
	public void addObserver(Observer o) {
		this.observers.add(o);
		
	}
	@Override
	public void deleteObserver(Observer o) {
		this.observers.remove(o);
		
	}
	@Override
	public void notifyObservers() {
		for(Observer o : observers) {
			o.update(temprature,hum,pre);
		}
		
	}
	
}


class CurrentConditionsDisplay implements Observer{

	public void update(float temprature,int hum,float pre) {
		System.out.println("Weather is updated in current cond. Display");
		
	}
	
}

class StatisticsDisplay implements Observer {

	@Override
	public void update(float temprature,int hum,float pre) {
		System.out.println("Statistics Display is updated");
		
	}
	
}
