package com.example.newsfetcher.feature.main_screen.weather.data

import com.example.newsfetcher.feature.main_screen.weather.data.model.WeathersRemoteModel


fun WeathersRemoteModel.toDomian() = WeatherModel(
    temperature = this.main.temperature,
    pressure = this.main.pressure,
    humidity = this.main.humidity
)