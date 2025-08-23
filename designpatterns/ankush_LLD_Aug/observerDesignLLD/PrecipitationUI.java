package designpatterns.designpatterns.ankush_LLD_Aug.observerDesignLLD;

public class PrecipitationUI implements Observer{
    @Override
    public void updateInfo(WeatherInfo weatherInfo) {
        System.out.println("Precipitation updated " + weatherInfo.getPrecipitation());
    }
}
