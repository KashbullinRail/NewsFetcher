package com.example.newsfetcher.feature.weather.data

import com.example.newsfetcher.feature.weather.data.model.WeathersRemoteModel


fun WeathersRemoteModel.toDomian() = WeatherModel(
    temperature = main.temperature ?: "",
    pressure = main.pressure ?: "",
    humidity = main.humidity ?: ""
)