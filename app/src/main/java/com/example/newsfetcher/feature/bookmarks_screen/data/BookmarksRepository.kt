package com.example.newsfetcher.feature.bookmarks_screen.data

import com.example.newsfetcher.feature.main_screen.news.data.ArticleModel


interface BookmarksRepository {

    suspend fun create(model: ArticleModel)

    suspend fun read(): List<ArticleModel>

    suspend fun update(model: ArticleModel)

    suspend fun delete(model: ArticleModel)

}