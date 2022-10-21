package com.example.newsfetcher.feature.data

import com.example.newsfetcher.feature.data.model.ArticlesRemoteModel

class ArticlesRemoteSource(private val api: NewsAPI) {
    suspend fun getArticles(): ArticlesRemoteModel {
        return api.getArticles()
    }
}
