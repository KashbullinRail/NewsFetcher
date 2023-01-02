package com.example.newsfetcher.feature.main_screen.weather.data



interface WeatherRepository {

    suspend fun getTemperature(): WeatherModel
    suspend fun getPressure(): WeatherModel
    suspend fun getHumidity(): WeatherModel
}