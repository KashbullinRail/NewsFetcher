package com.example.newsfetcher.feature.news_source_screen.data

import com.example.newsfetcher.feature.news_source_screen.data.model.SourceRemoteModel
import com.example.newsfetcher.feature.news_source_screen.domain.SourceModel

fun SourceRemoteModel.toDomain() = SourceModel(
    id = id.hashCode().toString(),
    name = name ?: "",
    description = description ?: "",
    url = url ?: "",
    selectSource = false,
)