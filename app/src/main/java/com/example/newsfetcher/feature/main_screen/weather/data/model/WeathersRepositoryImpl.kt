package com.example.newsfetcher.feature.main_screen.weather.data.model

import com.example.newsfetcher.feature.main_screen.weather.data.WeatherModel
import com.example.newsfetcher.feature.main_screen.weather.data.WeathersRemoteSource
import com.example.newsfetcher.feature.main_screen.weather.data.WeathersRepository
import com.example.newsfetcher.feature.main_screen.weather.data.toDomian


class WeathersRepositoryImpl(private val weatherRemoteSource: WeathersRemoteSource) : WeathersRepository {

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