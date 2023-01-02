package com.example.newsfetcher.feature.main_screen.weather.data

import com.example.newsfetcher.feature.main_screen.weather.data.model.WeathersRemoteModel


class WeathersRemoteSource(private val api: WeatherAPI) {

    suspend fun getWeather(): WeathersRemoteModel {
        return api.getWeather()
    }

}
