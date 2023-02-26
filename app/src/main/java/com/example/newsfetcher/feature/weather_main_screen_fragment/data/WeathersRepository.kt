package com.example.newsfetcher.feature.weather_main_screen_fragment.data



interface WeathersRepository {

    suspend fun getTemperature(): WeatherModel

    suspend fun getPressure(): WeatherModel

    suspend fun getHumidity(): WeatherModel

}