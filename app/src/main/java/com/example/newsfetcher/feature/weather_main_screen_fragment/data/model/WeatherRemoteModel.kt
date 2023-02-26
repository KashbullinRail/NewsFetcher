package com.example.newsfetcher.feature.weather_main_screen_fragment.data.model

import com.google.gson.annotations.SerializedName


data class WeatherRemoteModel(
    @SerializedName("temp")
    val temperature: String,
    @SerializedName("pressure")
    val pressure: String,
    @SerializedName("humidity")
    val humidity: String
)