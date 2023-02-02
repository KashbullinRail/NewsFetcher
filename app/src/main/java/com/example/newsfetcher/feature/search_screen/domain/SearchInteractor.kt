package com.example.newsfetcher.feature.search_screen.domain

import com.example.newsfetcher.base.attempt


class SearchInteractor(private val repository: ArticlesSearchRepository) {

    suspend fun getArticles() = attempt {
        repository.getArticles()
    }

    suspend fun searchSetting(searchSettingModel: String) {
        attempt { repository.setSearchSetting(searchSettingModel) }
    }

}



