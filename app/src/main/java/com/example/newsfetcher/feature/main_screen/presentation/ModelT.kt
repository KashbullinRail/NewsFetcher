package com.example.newsfetcher.feature.main_screen.presentation

import com.google.gson.annotations.SerializedName

data class ModelT(
    @SerializedName("title")
    val title: String = "rtergr",
    @SerializedName("age")
    val age: Int = 34,
    @SerializedName("yes")
    val yes: Boolean = false
)
