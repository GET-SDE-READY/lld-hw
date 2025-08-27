public class TemperatureObserver implements IObserver{

    private int temperature;
    @Override
    public void update(WeatherEvent weatherEvent) {
        this.temperature = weatherEvent.getTemperature();
    }

    @Override
    public void display() {
        System.out.println("Temperature will be "+ temperature +" C.");
    }
}
