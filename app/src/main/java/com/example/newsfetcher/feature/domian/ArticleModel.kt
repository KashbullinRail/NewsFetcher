package com.example.newsfetcher.feature.domian

import com.google.gson.annotations.SerializedName

data class ArticleModel(
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String
)