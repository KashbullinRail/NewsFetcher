package com.example.newsfetcher.feature.main_screen.weather_III_finishInTheFuture_III.data



interface WeathersRepository {

    suspend fun getTemperature(): WeatherModel

    suspend fun getPressure(): WeatherModel

    suspend fun getHumidity(): WeatherModel

}