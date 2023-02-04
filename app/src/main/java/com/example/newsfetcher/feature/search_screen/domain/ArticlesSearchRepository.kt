package com.example.newsfetcher.feature.search_screen.domain

import com.example.newsfetcher.feature.main_screen.domian.ArticleModel
import com.example.newsfetcher.feature.search_screen.data.model.SearchSettingModel


interface ArticlesSearchRepository {

    suspend fun getArticles(): List<ArticleModel>

    fun setSearchText(searchTextSet: String)

    fun setSearchSetting(searchSettingModel: SearchSettingModel)

    fun getSearchSetting(): SearchSettingModel

}