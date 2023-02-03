package com.example.newsfetcher.feature.search_screen.data.model

import com.example.newsfetcher.feature.main_screen.data.toDomian
import com.example.newsfetcher.feature.main_screen.domian.ArticleModel
import com.example.newsfetcher.feature.search_screen.data.SearchArticlesRemoteSource
import com.example.newsfetcher.feature.search_screen.domain.ArticlesSearchRepository


class ArticlesSearchRemoteRepositoryImpl(private val source: SearchArticlesRemoteSource) :
    ArticlesSearchRepository {

    override suspend fun getArticles(): List<ArticleModel> {
        return source.getArticles().articlesList.map {
            it.toDomian()
        }
    }

    override fun setSearchText(searchSettingModel: String) {
        source.setSearchText(searchSettingModel)
    }

    override fun setSearchSetting(searchSettingModel: SearchSettingModel) {
        source.setSearchSetting(searchSettingModel)
    }

    override fun getSearchSetting(): SearchSettingModel {
        return SearchSettingModel(
            searchIn = source.getSearchSetting().searchIn,
            dateTo = source.getSearchSetting().dateTo,
            dateFrom = source.getSearchSetting().dateFrom,
            sortBy = source.getSearchSetting().sortBy
        )
    }

}