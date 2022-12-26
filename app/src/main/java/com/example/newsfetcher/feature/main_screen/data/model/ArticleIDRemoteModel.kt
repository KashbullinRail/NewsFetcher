package com.example.newsfetcher.feature.main_screen.data.model

import com.google.gson.annotations.SerializedName

data class ArticleIDRemoteModel(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String
)

