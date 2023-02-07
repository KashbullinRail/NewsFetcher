package com.example.newsfetcher.feature.weather_main_screen_fragment.data

import com.example.newsfetcher.feature.weather_main_screen_fragment.data.model.WeathersRemoteModel


class WeathersRemoteSource(private val api: WeatherAPI) {

    suspend fun getWeather(): WeathersRemoteModel {
        return api.getWeather()
    }

}
