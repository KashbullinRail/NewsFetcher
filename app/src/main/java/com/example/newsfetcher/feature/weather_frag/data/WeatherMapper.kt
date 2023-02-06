package com.example.newsfetcher.feature.weather_frag.data

import com.example.newsfetcher.feature.weather_frag.data.model.WeathersRemoteModel


fun WeathersRemoteModel.toDomian() = WeatherModel(
    temperature = main.temperature ?: "",
    pressure = main.pressure ?: "",
    humidity = main.humidity ?: ""
)