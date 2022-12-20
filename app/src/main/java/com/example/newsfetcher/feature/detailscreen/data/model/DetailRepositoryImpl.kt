package com.example.newsfetcher.feature.detailscreen.data.model

import com.example.newsfetcher.feature.bookmarks.data.toDomain
import com.example.newsfetcher.feature.bookmarks.data.toEntity
import com.example.newsfetcher.feature.detailscreen.data.DetailLocalSource
import com.example.newsfetcher.feature.detailscreen.data.DetailRepository
import com.example.newsfetcher.feature.main_screen.domian.ArticleModel


class DetailRepositoryImpl(private val bookmarksLocalSource: DetailLocalSource) :
    DetailRepository {

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