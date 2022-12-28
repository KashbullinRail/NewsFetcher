package com.example.newsfetcher.feature.search_screen.data

import com.example.newsfetcher.feature.main_screen.data.model.ArticlesRemoteModel
import com.example.newsfetcher.feature.main_screen.presentation.UIEvent


class SearchArticlesRemoteSource(private val api: SearchNewsAPI) {

    suspend fun getArticles(): ArticlesRemoteModel {
        return api.getArticles("Choice")
    }

}
