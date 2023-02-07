package com.example.newsfetcher.feature.weather_main_screen_fragment.data

import com.example.newsfetcher.feature.weather_main_screen_fragment.data.model.WeathersRemoteModel
import com.example.newsfetcher.feature.weather_main_screen_fragment.di.API_KEY_WEATHER
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherAPI {

    @GET("weather")
    suspend fun getWeather(
        @Query("q") query: String = "Kazan",
        @Query("units") units :String = "metric",
        @Query("appid") apiKey: String = API_KEY_WEATHER
    ): WeathersRemoteModel

}