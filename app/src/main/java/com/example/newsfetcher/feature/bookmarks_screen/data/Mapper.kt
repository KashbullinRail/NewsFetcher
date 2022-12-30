package com.example.newsfetcher.feature.bookmarks_screen.data

import com.example.newsfetcher.feature.bookmarks_screen.data.model.BookmarkEntity
import com.example.newsfetcher.feature.main_screen.domian.ArticleModel


fun BookmarkEntity.toDomain() = ArticleModel(
//    id = idD,
    name = name,
    author = author,
    title = title,
    description = description,
    url = url,
    urlToImage = urlToImage,
    publishedAt = publishedAt,
    content = content
)

fun ArticleModel.toEntity() = BookmarkEntity(
//    idD = id,
    name = name,
    author = author,
    title = title,
    description = description,
    url = url,
    urlToImage = urlToImage,
    publishedAt = publishedAt,
    content = content
)