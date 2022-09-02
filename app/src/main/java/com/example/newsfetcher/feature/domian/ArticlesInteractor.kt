package com.example.newsfetcher.feature.domian

import com.example.newsfetcher.base.attempt
import com.example.newsfetcher.feature.data.ArticlesRepository

class ArticlesInteractor(private val repository: ArticlesRepository) {
    suspend fun getArticles() = attempt { repository.getArticles() }

}