package com.example.newsfetcher.feature.main_screen.data

import com.example.newsfetcher.feature.main_screen.data.model.ArticlesRemoteModel
import com.example.newsfetcher.feature.main_screen.di.setUrl
import kotlinx.coroutines.delay


class ArticlesRemoteSource(private val api: NewsAPI) {

    suspend fun getArticles(): ArticlesRemoteModel {
        return api.getArticles()
    }

}
