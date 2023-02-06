package com.example.newsfetcher.feature.weather_frag.data

import com.example.newsfetcher.feature.weather_frag.data.model.WeathersRemoteModel


class WeathersRemoteSource(private val api: WeatherAPI) {

    suspend fun getWeather(): WeathersRemoteModel {
        return api.getWeather()
    }

}
