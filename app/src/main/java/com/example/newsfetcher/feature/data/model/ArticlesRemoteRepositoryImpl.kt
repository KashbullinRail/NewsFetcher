package com.example.newsfetcher.feature.data.model

import com.example.newsfetcher.feature.data.ArticlesRemoteSource
import com.example.newsfetcher.feature.data.ArticlesRepository
import com.example.newsfetcher.feature.data.toDomian
import com.example.newsfetcher.feature.domian.ArticleModel

class ArticlesRemoteRepositoryImpl(private val source: ArticlesRemoteSource) : ArticlesRepository {
    override suspend fun getArticles(): List<ArticleModel> {
        return source.getArticles().articlesList.asSequence().map {
            it.toDomian()
        }.mapIndexed { index, articleModel ->
            articleModel.copy(
                publishedAt = index.toString()
            )
        }.filter {
            it.publishedAt.toInt() % 2 == 0
        }.toList()
    }
}