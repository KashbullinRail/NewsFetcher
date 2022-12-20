package com.example.newsfetcher.feature.main_screen.data

import com.example.newsfetcher.feature.main_screen.data.model.ArticlesRemoteModel


class ArticlesRemoteSource(private val api: NewsAPI) {

    suspend fun getArticles(): ArticlesRemoteModel {
        return api.getArticles()
    }

}
