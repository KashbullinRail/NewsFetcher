package com.example.newsfetcher.feature.weather_III_finishInTheFuture_III.data

import com.example.newsfetcher.feature.weather_III_finishInTheFuture_III.data.model.WeathersRemoteModel


class WeathersRemoteSource(private val api: WeatherAPI) {

    suspend fun getWeather(): WeathersRemoteModel {
        return api.getWeather()
    }

}