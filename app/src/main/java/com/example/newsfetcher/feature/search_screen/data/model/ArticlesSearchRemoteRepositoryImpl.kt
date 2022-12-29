package com.example.newsfetcher.feature.search_screen.data.model

import com.example.newsfetcher.feature.main_screen.data.toDomian
import com.example.newsfetcher.feature.main_screen.domian.ArticleModel
import com.example.newsfetcher.feature.search_screen.data.ArticlesSearchRepository
import com.example.newsfetcher.feature.search_screen.data.SearchArticlesRemoteSource


class ArticlesSearchRemoteRepositoryImpl(private val source: SearchArticlesRemoteSource) : ArticlesSearchRepository {

    override suspend fun getArticles(): List<ArticleModel> {
        return source.getArticles().articlesList.map {
            it.toDomian()
        }
    }

}