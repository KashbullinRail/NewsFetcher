package com.example.newsfetcher.feature.weather_main_screen_fragment.domain

import com.example.newsfetcher.base.Either
import com.example.newsfetcher.base.attempt
import com.example.newsfetcher.feature.weather_main_screen_fragment.data.WeatherModel
import com.example.newsfetcher.feature.weather_main_screen_fragment.data.WeathersRepository


class WeatherInteractor(private val weatherRepo: WeathersRepository) {

    suspend fun getWeather(): Either<Throwable, WeatherModel> {
        return attempt { weatherRepo.getTemperature() }
    }
}

//TODO -> JSON converter
//                var gson = Gson()
//                var json = gson.toJson(ModelT())
//                println("json= $json")
//                var fromJson = gson.fromJson(json, ModelT::class.java)
//                println("fromJson=$fromJson      ${fromJson.age}    ${fromJson.title}   ${fromJson.yes}")