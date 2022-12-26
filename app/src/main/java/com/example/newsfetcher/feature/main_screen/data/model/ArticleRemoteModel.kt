package com.example.newsfetcher.feature.main_screen.data.model

import com.google.gson.annotations.SerializedName


data class ArticleRemoteModel(
//    @SerializedName("source")
//    val source: List<ArticleIDRemoteModel>,
    @SerializedName("author")
    val author: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("url")
    val url: String,
    @SerializedName("urlToImage")
    val urlToImage: String?,
    @SerializedName("publishedAt")
    val publishedAt: String,
    @SerializedName("content")
    val content: String
)