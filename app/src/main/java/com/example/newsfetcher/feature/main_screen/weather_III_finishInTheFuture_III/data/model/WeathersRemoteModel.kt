package com.example.newsfetcher.feature.main_screen.weather_III_finishInTheFuture_III.data.model

import com.google.gson.annotations.SerializedName


data class WeathersRemoteModel(
    @SerializedName("main")
    val main : WeatherRemoteModel
)
