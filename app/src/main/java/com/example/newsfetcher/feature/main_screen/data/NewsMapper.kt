package com.example.newsfetcher.feature.main_screen.data

import com.example.newsfetcher.feature.main_screen.data.model.ArticleRemoteModel
import com.example.newsfetcher.feature.main_screen.domian.ArticleModel


fun ArticleRemoteModel.toDomian() = ArticleModel(
//    id = UUID.randomUUID().toString(), //duplication occurs when the network is re-requested
    id = title.hashCode().toString(),
    name = source.name ?: "",
    title = title ?: "",
    author = author ?: "",
    description = description ?: "",
    url = url ?: "",
    urlToImage = urlToImage ?: "",
    publishedAt = publishedAt?.replaceFirst("T", " ")?.removeSuffix("Z") ?: "",
    content = content ?: "",
    selectedBookmark = false
)