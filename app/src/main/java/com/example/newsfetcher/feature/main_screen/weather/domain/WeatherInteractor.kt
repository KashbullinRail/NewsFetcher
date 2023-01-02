package com.example.newsfetcher.feature.main_screen.weather.domain

import com.example.newsfetcher.base.Either
import com.example.newsfetcher.base.attempt
import com.example.newsfetcher.feature.main_screen.weather.data.WeatherModel
import com.example.newsfetcher.feature.main_screen.weather.data.WeathersRepository


class WeatherInteractor(private val weatherRepo: WeathersRepository) {

    suspend fun getWeather(): Either<Throwable, WeatherModel> {
        return attempt { weatherRepo.getTemperature() }
    }
}