package ke.co.kodelite.monsoon.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ke.co.kodelite.monsoon.api.WeatherApi
import ke.co.kodelite.monsoon.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBaseUrl()= Constants.BASE_URL

    @Provides
    @Singleton
    fun provideRetrofitInstance(BASE_URL:String):WeatherApi=
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)

}