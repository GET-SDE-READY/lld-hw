class CurrentConditionsDisplay(
    var name: String
) : Observer {
    private var temp: Double = 0.0
    private var humidity: Double = 0.0

    override fun update(weatherStationMessage: WeatherStationMessage) {
        this.temp = weatherStationMessage.temp
        this.humidity = weatherStationMessage.humidity
    }

    fun getCurrentWeatherConditions(): String {
        return "Current Conditions: ${this.temp} degree C, ${this.humidity} % Humidity"
    }
}