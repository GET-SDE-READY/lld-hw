interface WeatherStationSubject {
    fun registerObserver(observer: Observer)
    fun removeObserver(observer: Observer)
    fun notifyObservers(weatherStationMessage: WeatherStationMessage)
}