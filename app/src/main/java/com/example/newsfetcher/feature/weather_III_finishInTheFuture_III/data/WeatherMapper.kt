package com.example.newsfetcher.feature.weather_III_finishInTheFuture_III.data

import com.example.newsfetcher.feature.weather_III_finishInTheFuture_III.data.model.WeathersRemoteModel


fun WeathersRemoteModel.toDomian() = WeatherModel(
    temperature = main.temperature ?: "",
    pressure = main.pressure ?: "",
    humidity = main.humidity ?: ""
)