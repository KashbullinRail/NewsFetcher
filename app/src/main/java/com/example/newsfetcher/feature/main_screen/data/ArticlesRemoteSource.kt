package com.example.newsfetcher.feature.main_screen.data

import com.example.newsfetcher.feature.favourite_news_setting_screen.presentation.FavouriteNews
import com.example.newsfetcher.feature.main_screen.data.model.ArticlesRemoteModel
import com.example.newsfetcher.feature.main_screen.di.setUrl
import kotlinx.coroutines.delay


class ArticlesRemoteSource(private val api: NewsAPI) {

    companion object {
        private var favouriteNews: String = ""
    }

    suspend fun getArticles(): ArticlesRemoteModel {
        return api.getArticles(
            category = favouriteNews
        )
    }

    fun setFavouriteNews(setFavouriteNews: String) {
        favouriteNews = setFavouriteNews
    }

    fun getFavouriteNews(): String {
        return favouriteNews
    }

}
