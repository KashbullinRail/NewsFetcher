package com.example.newsfetcher.feature.main_screen.news.data.model

import com.example.newsfetcher.feature.main_screen.news.data.ArticlesRemoteSource
import com.example.newsfetcher.feature.main_screen.news.data.ArticlesRepository
import com.example.newsfetcher.feature.main_screen.news.data.toDomian
import com.example.newsfetcher.feature.main_screen.news.domian.ArticleModel


class ArticlesRemoteRepositoryImpl(private val source: ArticlesRemoteSource) : ArticlesRepository {

    override suspend fun getArticles(): List<ArticleModel> {
        return source.getArticles().articlesList.map {
            it.toDomian()
        }
    }

}