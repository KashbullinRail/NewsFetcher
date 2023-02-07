package com.example.newsfetcher.feature.news_source_screen.data

import com.example.newsfetcher.feature.news_source_screen.data.model.SourcesRemoteModel

class SourcesRemoteSource(private val api: SourceAPI) {

    suspend fun getSources(): SourcesRemoteModel {
       return api.getArticles()
    }

}