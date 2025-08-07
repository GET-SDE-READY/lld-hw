package Design_Patterns.Behavioral.WeatherStation;

public class Main {

	public static void main(String[] args) {

		WeatherStation weatherStation = new WeatherStation();
		Dashboard dashboard = new Dashboard(weatherStation);
		Stats stats = new Stats(weatherStation);
		weatherStation.weatherstatechanged(34, 20, 100, false);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		weatherStation.weatherstatechanged(14, 90, 250, true);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		weatherStation.weatherstatechanged(42, 62, 134, false);

	}

}
