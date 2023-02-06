package com.example.newsfetcher.feature.main_screen.data

import com.example.newsfetcher.feature.main_screen.domian.ArticleModel


interface ArticlesRepository {

    suspend fun getArticles(): List<ArticleModel>

    fun setFavouriteNews(setFavouriteNews: String)

    fun getFavouriteNews(): String

}