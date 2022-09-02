package com.example.newsfetcher.feature.data

import com.example.newsfetcher.feature.domian.ArticleModel

interface ArticlesRepository {
    suspend fun getArticles() : List<ArticleModel>
}