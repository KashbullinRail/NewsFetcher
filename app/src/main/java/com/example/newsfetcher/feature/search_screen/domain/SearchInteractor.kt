package com.example.newsfetcher.feature.search_screen.domain

import com.example.newsfetcher.base.attempt
import com.example.newsfetcher.feature.search_screen.data.model.SearchSettingModel


class SearchInteractor(private val repository: ArticlesSearchRepository) {

    suspend fun getArticles() = attempt {
        repository.getArticles()
    }

    fun setSearchText(searchTextSet: String) {
        attempt { repository.setSearchText(searchTextSet) }
    }

    fun setSearchSetting(searchSettingModel: SearchSettingModel) {
        attempt { repository.setSearchSetting(searchSettingModel) }
    }

    fun getSearchSetting():SearchSettingModel {
       return repository.getSearchSetting()
    }

}



