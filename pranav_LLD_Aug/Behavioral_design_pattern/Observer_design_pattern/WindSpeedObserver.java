public class WindSpeedObserver implements IObserver {

    private int windSpeed;
    @Override
    public void update(WeatherEvent weatherEvent) {
        this.windSpeed = weatherEvent.getWindSpeed();
    }

    @Override
    public void display() {

        System.out.println("Wind speed will be "+ windSpeed +" m/s.");
    }
}
