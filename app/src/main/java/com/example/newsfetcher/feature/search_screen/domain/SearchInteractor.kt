package com.example.newsfetcher.feature.search_screen.domain

import com.example.newsfetcher.base.attempt
import com.example.newsfetcher.feature.main_screen.data.ArticlesRepository


class SearchInteractor(private val repository: ArticlesRepository) {

    suspend fun getArticles() = attempt {
        repository.getArticles()
    }

}



