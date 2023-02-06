package com.example.newsfetcher.feature.weather_frag.data.model

import com.google.gson.annotations.SerializedName


data class WeathersRemoteModel(
    @SerializedName("main")
    val main : WeatherRemoteModel
)
