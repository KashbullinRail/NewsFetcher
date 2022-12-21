package com.example.newsfetcher.feature.detailscreen.data

import com.example.newsfetcher.feature.detailscreen.data.model.DetailEntity
import com.example.newsfetcher.feature.main_screen.domian.ArticleModel


fun DetailEntity.toDomain() = ArticleModel(
    author = author,
    title = title,
    description = description,
    url = url,
    urlToImage = urlToImage,
    publishedAt = publishedAt
)

fun ArticleModel.toEntity() = DetailEntity(
    author = author,
    title = title,
    description = description,
    url = url,
    urlToImage = urlToImage,
    publishedAt = publishedAt
)