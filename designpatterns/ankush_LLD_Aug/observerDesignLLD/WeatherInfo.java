package designpatterns.designpatterns.ankush_LLD_Aug.observerDesignLLD;

public class WeatherInfo {
    private String temperature;
    private String precipitation;
    private  String windSpeed;

    public WeatherInfo(String temperature, String precipitation, String windSpeed) {
        this.temperature = temperature;
        this.precipitation = precipitation;
        this.windSpeed = windSpeed;
    }

    public WeatherInfo() {
    }

    public String getCurrentTemperature() {
        return temperature;
    }

    public void setCurrentTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(String precipitation) {
        this.precipitation = precipitation;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }
}
