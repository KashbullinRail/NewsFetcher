package com.example.newsfetcher.feature.main_screen.news.data

import com.example.newsfetcher.feature.main_screen.news.domian.ArticleModel


interface ArticlesRepository {

    suspend fun getArticles(): List<ArticleModel>

}