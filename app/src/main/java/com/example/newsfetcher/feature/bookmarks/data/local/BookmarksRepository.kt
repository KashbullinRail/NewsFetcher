package com.example.newsfetcher.feature.bookmarks.data.local

import com.example.newsfetcher.feature.bookmarks.data.local.model.BookmarkEntity
import com.example.newsfetcher.feature.domian.ArticleModel

interface BookmarksRepository {

    suspend fun create(model: ArticleModel)

    suspend fun read(): List<ArticleModel>

    suspend fun update(model: ArticleModel)

    suspend fun delete(model: ArticleModel)

}