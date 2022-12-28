package com.example.newsfetcher.feature.search_screen.domain

import com.example.newsfetcher.base.attempt
import com.example.newsfetcher.feature.main_screen.data.ArticlesRepository
import com.example.newsfetcher.feature.search_screen.data.ArticlesSearchRepository


class SearchInteractor(private val repository: ArticlesSearchRepository) {

    suspend fun getArticles() = attempt {
        repository.getArticles()
    }

}



