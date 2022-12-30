package com.example.newsfetcher.feature.main_screen.domian



data class ArticleModel(
    val name: String,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
) : java.io.Serializable
