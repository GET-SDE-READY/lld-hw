package designpatterns.designpatterns.ankush_LLD_Aug.observerDesignLLD;

public class WindSpeedUi implements Observer{
    @Override
    public void updateInfo(WeatherInfo weatherInfo) {
        System.out.println("WindSpeedUI updated " + weatherInfo.getWindSpeed());
    }
}
