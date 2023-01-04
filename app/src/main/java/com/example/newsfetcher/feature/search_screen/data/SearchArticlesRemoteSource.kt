package com.example.newsfetcher.feature.search_screen.data

import com.example.newsfetcher.feature.main_screen.news.data.model.ArticlesRemoteModel


class SearchArticlesRemoteSource(private val api: SearchNewsAPI) {

    companion object {
        var qqq = "" //TODO implement via interface
    }

    suspend fun getArticles(): ArticlesRemoteModel {
        return api.getArticles(query = qqq)
    }

}
