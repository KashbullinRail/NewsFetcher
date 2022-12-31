package com.example.newsfetcher.feature.details_creen.data

import com.example.newsfetcher.feature.main_screen.domian.ArticleModel


interface DetailRepository {

    suspend fun create(model: ArticleModel)

    suspend fun read(): List<ArticleModel>

    suspend fun update(model: ArticleModel)

    suspend fun delete(model: ArticleModel)

}