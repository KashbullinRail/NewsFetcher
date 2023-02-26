package com.example.newsfetcher.feature.weather_main_screen_fragment.data

import com.example.newsfetcher.feature.weather_main_screen_fragment.data.model.WeathersRemoteModel


fun WeathersRemoteModel.toDomian() = WeatherModel(
    temperature = main.temperature ?: "",
    pressure = main.pressure ?: "",
    humidity = main.humidity ?: ""
)