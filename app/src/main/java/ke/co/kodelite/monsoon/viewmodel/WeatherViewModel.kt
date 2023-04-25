package ke.co.kodelite.monsoon.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ke.co.kodelite.monsoon.model.Weather
import ke.co.kodelite.monsoon.repository.WeatherRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel

class WeatherViewModel
@Inject
constructor(private val repository: WeatherRepository):ViewModel(){

    private val _response=MutableLiveData<Weather>()

    val weatherResponse: LiveData<Weather> get()=_response

    init {
        getWeatherForecast()
    }

    private fun getWeatherForecast()=viewModelScope.launch{
        repository.getWeather().let {
            response ->  if (response.isSuccessful){
                _response.postValue(response.body())
            }else{
                Log.d(TAG,"Get Forecast errror response ${response.message()}")
            }
        }
    }

}