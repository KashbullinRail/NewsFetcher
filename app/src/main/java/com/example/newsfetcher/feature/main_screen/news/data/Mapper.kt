package com.example.newsfetcher.feature.main_screen.news.data

import com.example.newsfetcher.feature.main_screen.news.data.model.ArticleRemoteModel
import com.example.newsfetcher.feature.main_screen.news.domian.ArticleModel
import java.util.UUID


fun ArticleRemoteModel.toDomian() = ArticleModel(
    id = UUID.randomUUID().toString(),
    name = source.name ?: "",
    title = title ?: "",
    author = author ?: "",
    description = description ?: "",
    url = url ?: "",
    urlToImage = urlToImage ?: "",
    publishedAt = publishedAt.replaceFirst("T", " ").removeSuffix("Z") ?: "",
    content = content ?: "",
    selectedBookmark = false
)