package com.example.newsfetcher.feature.search_screen.domain

import com.example.newsfetcher.feature.main_screen.domian.ArticleModel
import com.example.newsfetcher.feature.search_setting_screen.presentation.date_set_screen.model.SearchSettingModel


interface ArticlesSearchRepository {

    suspend fun getArticles(): List<ArticleModel>

    fun setSearchText(searchText: String)

    fun setSearchSetting(searchSettingModel: SearchSettingModel)

}