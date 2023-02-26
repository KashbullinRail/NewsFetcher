package com.example.newsfetcher.feature.source_bookmarks_screen.data.model

import com.example.newsfetcher.feature.news_source_screen.domain.SourceModel
import com.example.newsfetcher.feature.source_bookmarks_screen.data.SourceBookmarksLocalSource
import com.example.newsfetcher.feature.source_bookmarks_screen.data.toDomain
import com.example.newsfetcher.feature.source_bookmarks_screen.data.toEntity
import com.example.newsfetcher.feature.source_bookmarks_screen.domain.SourceBookmarksRepository


class SourceBookmarksRepositoryImpl(private val sourceBookmarksLocalSource: SourceBookmarksLocalSource) :
    SourceBookmarksRepository {

    override suspend fun create(model: SourceModel) {
        sourceBookmarksLocalSource.create(model.toEntity())
    }

    override suspend fun read(): List<SourceModel> {
        return sourceBookmarksLocalSource.read().map { it.toDomain() }
    }

    override suspend fun update(model: SourceModel) {
        sourceBookmarksLocalSource.update(model.toEntity())
    }

    override suspend fun delete(model: SourceModel) {
        sourceBookmarksLocalSource.delete(model.toEntity())
    }

}