package com.example.newsfetcher.feature.news_source_screen.data.model

import com.google.gson.annotations.SerializedName


data class SourceRemoteModel(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("url")
    val url: String,
)