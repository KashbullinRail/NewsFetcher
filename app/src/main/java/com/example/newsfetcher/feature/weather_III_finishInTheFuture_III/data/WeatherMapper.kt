package com.example.newsfetcher.feature.weather_III_finishInTheFuture_III.data

import com.example.newsfetcher.feature.weather_III_finishInTheFuture_III.data.model.WeathersRemoteModel


fun WeathersRemoteModel.toDomian() = WeatherModel(
    temperature = this.main.temperature,
    pressure = this.main.pressure,
    humidity = this.main.humidity
)