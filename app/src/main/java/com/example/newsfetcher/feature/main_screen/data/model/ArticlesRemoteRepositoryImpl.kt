package com.example.newsfetcher.feature.main_screen.data.model

import com.example.newsfetcher.feature.favourite_news_setting_screen.presentation.model.SetFavouriteNewsSettingModel
import com.example.newsfetcher.feature.main_screen.data.ArticlesRemoteSource
import com.example.newsfetcher.feature.main_screen.domian.ArticlesRepository
import com.example.newsfetcher.feature.main_screen.data.toDomian
import com.example.newsfetcher.feature.main_screen.domian.ArticleModel


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