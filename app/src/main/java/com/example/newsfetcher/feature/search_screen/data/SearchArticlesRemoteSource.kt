package com.example.newsfetcher.feature.search_screen.data

import com.example.newsfetcher.feature.main_screen.data.model.ArticlesRemoteModel


class SearchArticlesRemoteSource(private val api: SearchNewsAPI) {

    companion object {
       private var searchText = ""
        private var searchIn = ""
        private var dateFrom = ""
        private var dateTo = ""
        private var sortBy = ""
    }

    suspend fun getArticles(): ArticlesRemoteModel {
        return api.getArticles(query = searchText)
    }

    fun searchSetting(searchSettingModel: String){
        searchText = searchSettingModel
    }

}
