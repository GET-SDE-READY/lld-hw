public class PrecipitationObserver implements IObserver {

    private int precipitation;
    @Override
    public void update(WeatherEvent weatherEvent) {
        this.precipitation = weatherEvent.getPrecipitation();
    }

    @Override
    public void display() {
        System.out.println("Precipitation speed will be "+ precipitation +" mm.");
    }
}
