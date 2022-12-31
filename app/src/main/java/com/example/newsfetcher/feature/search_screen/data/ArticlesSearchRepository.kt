package com.example.newsfetcher.feature.search_screen.data

import com.example.newsfetcher.feature.main_screen.domian.ArticleModel


interface ArticlesSearchRepository {

    suspend fun getArticles(): List<ArticleModel>

}