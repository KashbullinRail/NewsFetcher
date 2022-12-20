package com.example.newsfetcher.feature.main_screen.data

import com.example.newsfetcher.feature.main_screen.data.model.ArticleRemoteModel
import com.example.newsfetcher.feature.main_screen.domian.ArticleModel


fun ArticleRemoteModel.toDomian() = ArticleModel(
    title = title ?: "",
    author = author ?: "",
    description = description ?: "",
    url = url,
    urlToImage = urlToImage ?: "",
    publishedAt = publishedAt

)