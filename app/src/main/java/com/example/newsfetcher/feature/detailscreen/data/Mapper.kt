package com.example.newsfetcher.feature.detailscreen.data

import com.example.newsfetcher.feature.bookmarks.data.model.BookmarkEntity
import com.example.newsfetcher.feature.detailscreen.data.model.DetailEntity
import com.example.newsfetcher.feature.main_screen.domian.ArticleModel


fun DetailEntity.toDomain() = ArticleModel(
//    id = id,
//    name = name,
    author = author,
    title = title,
    description = description,
    url = url,
    urlToImage = urlToImage,
    publishedAt = publishedAt,
    content = content
)

fun ArticleModel.toEntity() = DetailEntity(
//    id = id,
//    name = name,
    author = author,
    title = title,
    description = description,
    url = url,
    urlToImage = urlToImage,
    publishedAt = publishedAt,
    content = content
)