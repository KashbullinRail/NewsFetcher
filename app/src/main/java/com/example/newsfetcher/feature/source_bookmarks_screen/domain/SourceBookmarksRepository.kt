package com.example.newsfetcher.feature.source_bookmarks_screen.domain

import com.example.newsfetcher.feature.news_source_screen.domain.SourceModel


interface SourceBookmarksRepository {

    suspend fun create(model: SourceModel)

    suspend fun read(): List<SourceModel>

    suspend fun update(model: SourceModel)

    suspend fun delete(model: SourceModel)

}