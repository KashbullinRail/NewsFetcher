package com.example.newsfetcher.feature.weather.data

import com.example.newsfetcher.feature.weather.data.model.WeathersRemoteModel


class WeathersRemoteSource(private val api: WeatherAPI) {

    suspend fun getWeather(): WeathersRemoteModel {
        return api.getWeather()
    }

}
