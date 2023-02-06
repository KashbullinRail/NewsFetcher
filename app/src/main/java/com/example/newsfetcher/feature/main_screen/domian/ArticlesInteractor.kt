package com.example.newsfetcher.feature.main_screen.domian

import com.example.newsfetcher.base.attempt
import com.example.newsfetcher.feature.favourite_news_setting_screen.presentation.FavouriteNews
import com.example.newsfetcher.feature.main_screen.data.ArticlesRepository


class ArticlesInteractor(private val repository: ArticlesRepository) {

    suspend fun getArticles() = attempt {
        repository.getArticles()
    }

    fun setFavouriteNews(setFavouriteNews: String) = attempt {
        repository.setFavouriteNews(setFavouriteNews)
    }

    fun getFavouriteNews(): String = attempt {
        repository.getFavouriteNews()
    }.toString()

}



