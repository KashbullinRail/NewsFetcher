package com.example.newsfetcher.feature.main_screen.weather.domain

import com.example.newsfetcher.base.Either
import com.example.newsfetcher.base.attempt
import com.example.newsfetcher.feature.main_screen.weather.data.WeatherModel
import com.example.newsfetcher.feature.main_screen.weather.data.WeatherRepository


class WeatherInteractor(private val weatherRepo: WeatherRepository) {

    suspend fun getWeather(): Either<Throwable, WeatherModel> {
        return attempt { weatherRepo.getTemperature() }
    }
}