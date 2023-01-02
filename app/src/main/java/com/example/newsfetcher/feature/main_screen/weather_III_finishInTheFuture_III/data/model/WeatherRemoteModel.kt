package com.example.newsfetcher.feature.main_screen.weather_III_finishInTheFuture_III.data.model

import com.google.gson.annotations.SerializedName


data class WeatherRemoteModel(
    @SerializedName("temp")
    val temperature: String,
    @SerializedName("pressure")
    val pressure: String,
    @SerializedName("humidity")
    val humidity: String
)