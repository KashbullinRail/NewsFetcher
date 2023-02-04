package com.example.newsfetcher.feature.weather.data



interface WeathersRepository {

    suspend fun getTemperature(): WeatherModel

    suspend fun getPressure(): WeatherModel

    suspend fun getHumidity(): WeatherModel

}