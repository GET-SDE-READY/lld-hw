class WeatherStation: WeatherStationSubject {

    private val observers = mutableListOf<Observer>()

    private lateinit var weatherStationMessage: WeatherStationMessage

    fun setWeatherData(weatherStationMessage: WeatherStationMessage) {
        this.weatherStationMessage = weatherStationMessage
        notifyObservers(weatherStationMessage)
    }

    override fun registerObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    override fun notifyObservers(weatherStationMessage: WeatherStationMessage) {
        observers.forEach {
            it.update(weatherStationMessage)
        }
    }
}