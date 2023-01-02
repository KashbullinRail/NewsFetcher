package com.example.newsfetcher.feature.main_screen.news.data.model

import com.google.gson.annotations.SerializedName


data class ArticlesRemoteModel(
    @SerializedName("articles")
    val articlesList: List<ArticleRemoteModel>
)