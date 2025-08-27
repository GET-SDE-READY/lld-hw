import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements ISubject {

    List<IObserver> observerList;

    public WeatherStation() {
        observerList = new ArrayList<>();
    }

    @Override
    public void addObserver(IObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers(WeatherEvent weatherEvent) {

        System.out.println("Publishing message to observers");
        for(IObserver observer : observerList) {
            observer.update(weatherEvent);
        }

    }

    public void display() {
        for (IObserver o : observerList) {
            o.display();
        }
    }
}
