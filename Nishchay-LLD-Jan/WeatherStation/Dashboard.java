package Design_Patterns.Behavioral.WeatherStation;

public class Dashboard implements Observer {

	private Weather weather;

	public Dashboard(Observable observable) {
		weather = new Weather();
		observable.addObservers(this);
	}

	private void displayDashboard() {
		System.out.println("Current Temp: " + weather.getTemperature() + "\n" + "Current Humidity: "
				+ weather.getHumidity() + "\n" + "Current AQI: " + weather.getAqi() + "\n" + "Current Rainfall Status: "
				+ weather.isRainfall());
	}

	@Override
	public void update(Weather weather) {
		this.weather = weather;
		System.out.println("*******************(Displaying Dashboard results)*******************");
		displayDashboard();
		System.out.println("---------------------------------------------");
	}

}
