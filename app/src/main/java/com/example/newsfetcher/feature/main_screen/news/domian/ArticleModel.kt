package com.example.newsfetcher.feature.main_screen.news.domian

import java.io.Serializable


data class ArticleModel(
    val id: String,
    val name: String,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String,
    var selectedBookmark: Boolean
) : Serializable

