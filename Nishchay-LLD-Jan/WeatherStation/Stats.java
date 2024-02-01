package Design_Patterns.Behavioral.WeatherStation;

public class Stats implements Observer {

	private int max_temp;
	private int min_temp;
	private String aqi_insight = new String();

	public Stats(Observable observable) {
		this.max_temp = Integer.MIN_VALUE;
		this.min_temp = Integer.MAX_VALUE;
		observable.addObservers(this);
	}

	private void displayRainfall(boolean rainfall) {
		if (rainfall) {
			System.out.println("Rain Showers");
		} else {
			System.out.println("No Rain");
		}
	}

	private void displayAirQualityInsights(int aqi) {
		System.out.print("AIR QUALITY INSIGHTS: ");
		if (aqi >= 0 && aqi <= 50) {
			aqi_insight = "Good";
		} else if (aqi >= 51 && aqi <= 100) {
			aqi_insight = "Moderate";
		} else if (aqi >= 101 && aqi <= 150) {
			aqi_insight = "Unhealthy for Sensitive Groups";
		} else if (aqi >= 151 && aqi <= 200) {
			aqi_insight = "Unhealthy";
		} else if (aqi >= 201 && aqi <= 300) {
			aqi_insight = "Very Unhealthy";
		} else if (aqi > 300) {
			aqi_insight = "Hazardous";
		} else {
			throw new RuntimeException("Unexpected value");
		}
		System.out.println(aqi_insight);

	}

	private void displayTemperatueInsights(int temp) {
		max_temp = Math.max(temp, max_temp);
		min_temp = Math.min(temp, min_temp);
		System.out.println("MAX TEMPERATURE: " + max_temp + " " + "MIN TEMPERATURE: " + min_temp);
	}

	@Override
	public void update(Weather weather) {
		System.out.println("*******************(Displaying Insights)*******************");
		displayTemperatueInsights(weather.getTemperature());
		displayAirQualityInsights(weather.getAqi());
		displayRainfall(weather.isRainfall());
		System.out.println("---------------------------------------------");
	}

}
