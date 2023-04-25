package ke.co.kodelite.monsoon.api

import ke.co.kodelite.monsoon.model.Weather
import retrofit2.Response
import retrofit2.http.GET

interface WeatherApi {

    @GET("weather/Mombasa")
    suspend fun getForecast():Response<Weather>
}