package ke.co.kodelite.monsoon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ke.co.kodelite.monsoon.databinding.ActivityMainBinding
import ke.co.kodelite.monsoon.model.Forecast
import ke.co.kodelite.monsoon.viewmodel.WeatherViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel:WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.weatherResponse.observe(this) { forecast ->
            run {
                if (forecast != null) {

                    binding.apply {
                        tvDescription.text=forecast.description
                        tvTemperature.text= forecast.temperature
                        tvWind.text= forecast.wind

                       /* val tomorrowForecast=forecast.forecast[0]
                        tvNextDay.text="${"Day: "+tomorrowForecast.day}/${"Temp: "+tomorrowForecast.temperature}/${"Wind: "+tomorrowForecast.wind}"
*/
                    }


                }
            }

        }
    }
}