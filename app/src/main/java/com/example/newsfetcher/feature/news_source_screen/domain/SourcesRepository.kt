package com.example.newsfetcher.feature.news_source_screen.domain


interface SourcesRepository {

    suspend fun getSources(): List<SourceModel>

}