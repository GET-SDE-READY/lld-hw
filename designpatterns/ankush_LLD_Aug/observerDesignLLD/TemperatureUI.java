package designpatterns.designpatterns.ankush_LLD_Aug.observerDesignLLD;

public class TemperatureUI implements Observer{
    @Override
    public void updateInfo(WeatherInfo weatherInfo) {
        System.out.println("Temperature updated " + weatherInfo.getCurrentTemperature());
    }
}
