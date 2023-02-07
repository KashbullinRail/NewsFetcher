package com.example.newsfetcher.feature.news_source_screen.data.model

import com.example.newsfetcher.feature.news_source_screen.data.SourcesRemoteSource
import com.example.newsfetcher.feature.news_source_screen.data.toDomain
import com.example.newsfetcher.feature.news_source_screen.domain.SourceModel
import com.example.newsfetcher.feature.news_source_screen.domain.SourcesRepository

class SourcesRemoteRepositoryImp(private val source: SourcesRemoteSource): SourcesRepository {

    override suspend fun getSources(): List<SourceModel> {
        return source.getSources().sourcesList.map {
            it.toDomain()
        }
    }

}