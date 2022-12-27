package com.example.newsfetcher.feature.main_screen.domian

import com.example.newsfetcher.base.attempt
import com.example.newsfetcher.feature.main_screen.data.ArticlesRepository


class ArticlesInteractor(private val repository: ArticlesRepository) {

    suspend fun getArticles() = attempt {
        repository.getArticles()
    }

}



