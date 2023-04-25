package ke.co.kodelite.monsoon.repository

import ke.co.kodelite.monsoon.api.WeatherApi
import javax.inject.Inject

class WeatherRepository
@Inject
constructor(private val weatherApi: WeatherApi){

    suspend fun getWeather()=weatherApi.getForecast()
}