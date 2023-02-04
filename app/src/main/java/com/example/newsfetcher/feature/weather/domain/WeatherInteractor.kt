package com.example.newsfetcher.feature.weather.domain

import com.example.newsfetcher.base.Either
import com.example.newsfetcher.base.attempt
import com.example.newsfetcher.feature.weather.data.WeatherModel
import com.example.newsfetcher.feature.weather.data.WeathersRepository


class WeatherInteractor(private val weatherRepo: WeathersRepository) {

    suspend fun getWeather(): Either<Throwable, WeatherModel> {
        return attempt { weatherRepo.getTemperature() }
    }
}