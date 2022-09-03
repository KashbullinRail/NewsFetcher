package com.example.newsfetcher.feature.bookmarks.data.local

import com.example.newsfetcher.feature.bookmarks.data.toDomain
import com.example.newsfetcher.feature.bookmarks.data.toEntity
import com.example.newsfetcher.feature.domian.ArticleModel

class BookmarksRepositoryImpl(private val bookmarksLocalSource: BookmarksLocalSource): BookmarksRepository {
    override suspend fun create(model: ArticleModel) {
        bookmarksLocalSource.create(model.toEntity())
    }

    override suspend fun read(): List<ArticleModel> {
       return bookmarksLocalSource.read().map { it.toDomain() }
    }

    override suspend fun update(model: ArticleModel) {
        bookmarksLocalSource.update(model.toEntity())
    }

    override suspend fun delete(model: ArticleModel) {
        bookmarksLocalSource.delete(model.toEntity())
    }
}