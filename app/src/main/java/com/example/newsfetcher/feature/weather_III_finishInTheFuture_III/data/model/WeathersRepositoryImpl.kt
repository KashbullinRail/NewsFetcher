package com.example.newsfetcher.feature.weather_III_finishInTheFuture_III.data.model

import com.example.newsfetcher.feature.weather_III_finishInTheFuture_III.data.WeatherModel
import com.example.newsfetcher.feature.weather_III_finishInTheFuture_III.data.WeathersRemoteSource
import com.example.newsfetcher.feature.weather_III_finishInTheFuture_III.data.WeathersRepository
import com.example.newsfetcher.feature.weather_III_finishInTheFuture_III.data.toDomian


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