package com.example.newsfetcher.feature.search_screen.data

import com.example.newsfetcher.feature.main_screen.news.data.ArticleModel


interface ArticlesSearchRepository {

    suspend fun getArticles(): List<ArticleModel>

}