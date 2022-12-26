package com.example.newsfetcher.feature.main_screen.data.model

import com.google.gson.annotations.SerializedName
import java.util.Objects

data class ArticleIDRemoteModel(
    @SerializedName("id")
    val id: Objects,
    @SerializedName("name")
    val name: Objects
)

