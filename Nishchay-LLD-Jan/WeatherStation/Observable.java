package Design_Patterns.Behavioral.WeatherStation;

public interface Observable {

	void addObservers(Observer observer);

	void removeObservers(Observer observer);

	void notifySubscribedObservers();

}
