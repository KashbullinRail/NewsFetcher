package com.example.newsfetcher.feature.details_creen.data

import com.example.newsfetcher.feature.details_creen.data.model.DetailEntity
import com.example.newsfetcher.feature.main_screen.domian.ArticleModel


fun DetailEntity.toDomain() = ArticleModel(
    id = "detail",
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

fun ArticleModel.toEntity() = DetailEntity(
    name = name,
    author = author,
    title = title,
    description = description,
    url = url,
    urlToImage = urlToImage,
    publishedAt = publishedAt,
    content = content,
)