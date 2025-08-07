package Design_Patterns.Behavioral.WeatherStation;

public class Weather {

	private int temperature;
	private int humidity;
	private int aqi;
	private boolean rainfall;

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public int getAqi() {
		return aqi;
	}

	public void setAqi(int aqi) {
		this.aqi = aqi;
	}

	public boolean isRainfall() {
		return rainfall;
	}

	public void setRainfall(boolean rainfall) {
		this.rainfall = rainfall;
	}

}
