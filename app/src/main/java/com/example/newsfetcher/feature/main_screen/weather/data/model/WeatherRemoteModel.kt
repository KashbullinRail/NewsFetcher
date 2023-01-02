package com.example.newsfetcher.feature.main_screen.weather.data.model

import com.google.gson.annotations.SerializedName


data class WeatherRemoteModel(
    @SerializedName("temp")
    val temperature: String,
    @SerializedName("pressure")
    val pressure: String,
    @SerializedName("humidity")
    val humidity: String

)