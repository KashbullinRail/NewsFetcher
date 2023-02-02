package com.example.newsfetcher.feature.search_screen.data

import com.example.newsfetcher.feature.main_screen.data.model.ArticlesRemoteModel
import com.example.newsfetcher.feature.search_setting_screen.presentation.date_set_screen.model.SearchSettingModel


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

    fun setSearchText(searchSettingModel: String){
        searchText = searchSettingModel
    }

    fun setSearchSetting(searchSettingModel: SearchSettingModel) {
        searchIn = searchSettingModel.searchIn
        dateFrom = searchSettingModel.dateFrom
        dateTo = searchSettingModel.dateTo
        sortBy = searchSettingModel.sortBy
    }

}
