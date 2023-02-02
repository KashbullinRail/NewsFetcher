package com.example.newsfetcher.feature.search_screen.domain

import com.example.newsfetcher.base.attempt
import com.example.newsfetcher.feature.search_setting_screen.presentation.date_set_screen.model.SearchSettingModel


class SearchInteractor(private val repository: ArticlesSearchRepository) {

    suspend fun getArticles() = attempt {
        repository.getArticles()
    }

    fun setSearchText(searchSettingModel: String) {
        attempt { repository.setSearchText(searchSettingModel) }
    }

    fun setSearchSetting(searchSettingModel: SearchSettingModel) {
        attempt { repository.setSearchSetting(searchSettingModel) }
    }

}



