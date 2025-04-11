class StatisticsDisplay(
    var name: String
) : Observer {

    private var temp: Double = 0.0
    private var humidity: Double = 0.0
    private var pressure: Double = 0.0

    override fun update(weatherStationMessage: WeatherStationMessage) {
        this.temp = weatherStationMessage.temp
        this.humidity = weatherStationMessage.humidity
        this.pressure = weatherStationMessage.pressure
    }

    fun getCurrentWeatherConditions(): String {
        return "Statistics: Temp: ${this.temp} degree C, Humidity: ${this.humidity} %, Pressure: ${this.pressure} hpa"
    }
}