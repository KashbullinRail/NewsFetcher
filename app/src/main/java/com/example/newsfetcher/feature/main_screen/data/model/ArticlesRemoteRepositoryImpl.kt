package com.example.newsfetcher.feature.main_screen.data.model

import android.util.Log
import com.example.newsfetcher.feature.main_screen.data.ArticlesRemoteSource
import com.example.newsfetcher.feature.main_screen.data.ArticlesRepository
import com.example.newsfetcher.feature.main_screen.data.toDomian
import com.example.newsfetcher.feature.main_screen.domian.ArticleModel


class ArticlesRemoteRepositoryImpl(private val source: ArticlesRemoteSource) : ArticlesRepository {

    override suspend fun getArticles(): List<ArticleModel> {
        return source.getArticles().articlesList.map {
            it.toDomian()
        }
    }

}