package com.example.newsfetcher.feature.main_screen.data

import com.example.newsfetcher.feature.favourite_news_setting_screen.presentation.model.SetFavouriteNewsSettingModel
import com.example.newsfetcher.feature.main_screen.data.model.ArticlesRemoteModel


class ArticlesRemoteSource(private val api: NewsAPI) {

    companion object {
        private var favouriteNews: String = ""
    }

    suspend fun getArticles(): ArticlesRemoteModel {
        return api.getArticles(
            category = favouriteNews
        )
    }

    fun setFavouriteNews(setFavouriteNews: SetFavouriteNewsSettingModel) {
        favouriteNews = setFavouriteNews.favouriteNews
    }

    fun getFavouriteNews(): SetFavouriteNewsSettingModel {
        return SetFavouriteNewsSettingModel(favouriteNews = favouriteNews)
    }

}
