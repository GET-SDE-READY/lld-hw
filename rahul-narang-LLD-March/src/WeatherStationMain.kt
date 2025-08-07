fun main() {
    val weatherStationSubject = WeatherStation()

    val currentConditionsDisplayObserver = CurrentConditionsDisplay("Current Conditions Observer")
    val statisticsDisplayObserver = StatisticsDisplay("Statistics Display Observer")

    weatherStationSubject.registerObserver(currentConditionsDisplayObserver)
    weatherStationSubject.registerObserver(statisticsDisplayObserver)

    weatherStationSubject.setWeatherData(WeatherStationMessage(25.3, 65.0, 1012.2))

    println(currentConditionsDisplayObserver.getCurrentWeatherConditions())
    println(statisticsDisplayObserver.getCurrentWeatherConditions())
    println()

    weatherStationSubject.setWeatherData(WeatherStationMessage(28.9, 90.1, 1099.2))

    println(currentConditionsDisplayObserver.getCurrentWeatherConditions())
    println(statisticsDisplayObserver.getCurrentWeatherConditions())
    println()

    println("After removing the current conditions observer, values remain same in current conditions: ")
    weatherStationSubject.removeObserver(currentConditionsDisplayObserver)
    weatherStationSubject.setWeatherData(WeatherStationMessage(38.9, 10.1, 999.2))
    println(currentConditionsDisplayObserver.getCurrentWeatherConditions())
    println(statisticsDisplayObserver.getCurrentWeatherConditions())
    println()

    /**
     * Output:
        Current Conditions: 25.3 degree C, 65.0 % Humidity
        Statistics: Temp: 25.3 degree C, Humidity: 65.0 %, Pressure: 1012.2 hpa

        Current Conditions: 28.9 degree C, 90.1 % Humidity
        Statistics: Temp: 28.9 degree C, Humidity: 90.1 %, Pressure: 1099.2 hpa

        After removing the current conditions observer, values remain same in current conditions:
        Current Conditions: 28.9 degree C, 90.1 % Humidity
        Statistics: Temp: 38.9 degree C, Humidity: 10.1 %, Pressure: 999.2 hpa
     */
}

