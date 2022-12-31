package com.example.newsfetcher.feature.search_screen.data

import com.example.newsfetcher.feature.main_screen.data.model.ArticlesRemoteModel
import com.example.newsfetcher.feature.search_screen.presentation.ViewState


class SearchArticlesRemoteSource(private val api: SearchNewsAPI) {

    companion object {
        var qqq = "" //TODO implement via interface
    }

    suspend fun getArticles(): ArticlesRemoteModel {
        return api.getArticles(query = qqq)
    }

}
