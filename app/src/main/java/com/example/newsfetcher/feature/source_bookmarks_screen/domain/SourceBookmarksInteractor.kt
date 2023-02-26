package com.example.newsfetcher.feature.source_bookmarks_screen.domain

import com.example.newsfetcher.base.Either
import com.example.newsfetcher.base.attempt
import com.example.newsfetcher.feature.news_source_screen.domain.SourceModel


class SourceBookmarksInteractor(private val sourceBookmarksRepository: SourceBookmarksRepository) {

    suspend fun create(model: SourceModel) {
        attempt { sourceBookmarksRepository.create(model) }
    }

    suspend fun read(): Either<Throwable, List<SourceModel>> {
        return attempt { sourceBookmarksRepository.read() }
    }

    suspend fun update(model: SourceModel) {
        attempt { sourceBookmarksRepository.update(model) }
    }

    suspend fun delete(model: SourceModel) {
        attempt { sourceBookmarksRepository.delete(model) }
    }

}