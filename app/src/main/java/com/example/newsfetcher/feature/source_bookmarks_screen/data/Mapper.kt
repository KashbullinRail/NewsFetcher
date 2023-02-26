package com.example.newsfetcher.feature.source_bookmarks_screen.data

import com.example.newsfetcher.feature.news_source_screen.domain.SourceModel
import com.example.newsfetcher.feature.source_bookmarks_screen.data.model.SourceBookmarkEntity


fun SourceBookmarkEntity.toDomain() = SourceModel(
    id = id,
    name = name,
    description = description,
    url = url,
    selectSource = true
)

fun SourceModel.toEntity() = SourceBookmarkEntity(
    id = id,
    name = name,
    description = description,
    url = url,
)