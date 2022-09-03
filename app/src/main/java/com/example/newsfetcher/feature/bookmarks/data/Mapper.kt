package com.example.newsfetcher.feature.bookmarks.data

import com.example.newsfetcher.feature.bookmarks.data.local.model.BookmarkEntity
import com.example.newsfetcher.feature.domian.ArticleModel

fun BookmarkEntity.toDomain() = ArticleModel(
    author = author,
    title = title,
    description = description,
    url = url,
    urlToImage = urlToImage

)

fun ArticleModel.toEntity() = BookmarkEntity(
    author = author,
    title = title,
    description = description,
    url = url,
    urlToImage = urlToImage

)