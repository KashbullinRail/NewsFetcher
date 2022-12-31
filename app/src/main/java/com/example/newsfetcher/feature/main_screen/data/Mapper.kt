package com.example.newsfetcher.feature.main_screen.data

import com.example.newsfetcher.feature.main_screen.data.model.ArticleRemoteModel
import com.example.newsfetcher.feature.main_screen.domian.ArticleModel
import java.util.UUID


fun ArticleRemoteModel.toDomian() = ArticleModel(
    id = UUID.randomUUID().toString(),
    name = source.name ?: "",
    title = title ?: "",
    author = author ?: "",
    description = description ?: "",
    url = url ?: "",
    urlToImage = urlToImage ?: "",
    publishedAt = publishedAt ?: "",
    content = content ?: "",
    selectedBookmark = false
)