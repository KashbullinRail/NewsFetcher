package com.example.newsfetcher.feature.bookmarks_screen.data

import com.example.newsfetcher.feature.bookmarks_screen.data.model.BookmarkEntity
import com.example.newsfetcher.feature.main_screen.domian.ArticleModel
import java.util.UUID


fun BookmarkEntity.toDomain() = ArticleModel(
    id = id,
    name = name,
    author = author,
    title = title,
    description = description,
    url = url,
    urlToImage = urlToImage,
    publishedAt = publishedAt,
    content = content,
    selectedBookmark = true
)

fun ArticleModel.toEntity() = BookmarkEntity(
    id = id,
    name = name,
    author = author,
    title = title,
    description = description,
    url = url,
    urlToImage = urlToImage,
    publishedAt = publishedAt,
    content = content
)