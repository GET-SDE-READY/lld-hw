public class WeatherEvent {

  private int windSpeed;
  private int temperature;
  private int precipitation;
    public WeatherEvent(int windSpeed, int temperature, int precipitation) {
        this.windSpeed = windSpeed;
        this.temperature = temperature;
        this.precipitation = precipitation;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(int precipitation) {
        this.precipitation = precipitation;
    }


}
