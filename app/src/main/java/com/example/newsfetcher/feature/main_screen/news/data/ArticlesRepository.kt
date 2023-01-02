package com.example.newsfetcher.feature.main_screen.news.data


interface ArticlesRepository {

    suspend fun getArticles(): List<ArticleModel>

}