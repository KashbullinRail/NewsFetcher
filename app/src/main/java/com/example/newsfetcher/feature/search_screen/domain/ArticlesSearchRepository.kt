package com.example.newsfetcher.feature.search_screen.domain

import com.example.newsfetcher.feature.main_screen.domian.ArticleModel


interface ArticlesSearchRepository {

    suspend fun getArticles(): List<ArticleModel>

    suspend fun setSearchSetting(searchSettingModel: String)

}