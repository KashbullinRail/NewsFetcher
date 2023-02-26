package com.example.newsfetcher.feature.main_screen.domian

import com.example.newsfetcher.feature.favourite_news_setting_screen.presentation.model.SetFavouriteNewsSettingModel


interface ArticlesRepository {

    suspend fun getArticles(): List<ArticleModel>

    fun setFavouriteNews(setFavouriteNews: SetFavouriteNewsSettingModel)

    fun getFavouriteNews(): SetFavouriteNewsSettingModel

}