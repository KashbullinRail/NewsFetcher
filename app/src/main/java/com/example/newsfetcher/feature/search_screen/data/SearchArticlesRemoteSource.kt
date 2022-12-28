package com.example.newsfetcher.feature.search_screen.data

import com.example.newsfetcher.feature.main_screen.data.model.ArticlesRemoteModel


class SearchArticlesRemoteSource(private val api: SearchNewsAPI) {

    suspend fun getArticles(): ArticlesRemoteModel {
        return api.getArticles()
    }

}
