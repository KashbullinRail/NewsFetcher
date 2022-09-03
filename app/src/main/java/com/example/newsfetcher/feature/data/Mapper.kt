package com.example.newsfetcher.feature.data

import com.example.newsfetcher.feature.data.model.ArticleRemoteModel
import com.example.newsfetcher.feature.data.model.ArticlesRemoteModel
import com.example.newsfetcher.feature.domian.ArticleModel

fun ArticleRemoteModel.toDomian() = ArticleModel(
    title = title ?: "",
    author = author ?: "",
    description = description ?: "",
    url = url,
    urlToImage = urlToImage ?: ""
)