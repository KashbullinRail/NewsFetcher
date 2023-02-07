package com.example.newsfetcher.feature.main_screen.data.model

import com.example.newsfetcher.feature.favourite_news_setting_screen.presentation.SetFavouriteNewsSettingModel
import com.example.newsfetcher.feature.main_screen.data.ArticlesRemoteSource
import com.example.newsfetcher.feature.main_screen.data.ArticlesRepository
import com.example.newsfetcher.feature.main_screen.data.toDomian
import com.example.newsfetcher.feature.main_screen.di.setUrl
import com.example.newsfetcher.feature.main_screen.domian.ArticleModel
import kotlinx.coroutines.delay


class ArticlesRemoteRepositoryImpl(private val source: ArticlesRemoteSource) : ArticlesRepository {

    override suspend fun getArticles(): List<ArticleModel> {
        return source.getArticles().articlesList.map {
            it.toDomian()
        }
    }

    override fun setFavouriteNews(setFavouriteNews: SetFavouriteNewsSettingModel) {
       source.setFavouriteNews(setFavouriteNews)
    }

    override fun getFavouriteNews(): SetFavouriteNewsSettingModel {
       return source.getFavouriteNews()
    }

}