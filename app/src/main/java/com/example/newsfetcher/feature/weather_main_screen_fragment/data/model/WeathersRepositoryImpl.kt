package com.example.newsfetcher.feature.weather_main_screen_fragment.data.model

import com.example.newsfetcher.feature.weather_main_screen_fragment.data.WeatherModel
import com.example.newsfetcher.feature.weather_main_screen_fragment.data.WeathersRemoteSource
import com.example.newsfetcher.feature.weather_main_screen_fragment.data.WeathersRepository
import com.example.newsfetcher.feature.weather_main_screen_fragment.data.toDomian


class WeathersRepositoryImpl(private val weatherRemoteSource: WeathersRemoteSource) :
    WeathersRepository {

    override suspend fun getTemperature(): WeatherModel {
        return weatherRemoteSource.getWeather().toDomian()
    }

    override suspend fun getPressure(): WeatherModel {
        return weatherRemoteSource.getWeather().toDomian()
    }

    override suspend fun getHumidity(): WeatherModel {
        return weatherRemoteSource.getWeather().toDomian()
    }

}