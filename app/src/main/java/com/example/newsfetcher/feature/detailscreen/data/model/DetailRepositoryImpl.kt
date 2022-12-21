package com.example.newsfetcher.feature.detailscreen.data.model

import com.example.newsfetcher.feature.bookmarks.data.toDomain
import com.example.newsfetcher.feature.bookmarks.data.toEntity
import com.example.newsfetcher.feature.detailscreen.data.DetailLocalSource
import com.example.newsfetcher.feature.detailscreen.data.DetailRepository
import com.example.newsfetcher.feature.main_screen.domian.ArticleModel


class DetailRepositoryImpl(private val detailLocalSource: DetailLocalSource) :
    DetailRepository {

    override suspend fun create(model: ArticleModel) {
        detailLocalSource.create(model.toEntity())
    }

    override suspend fun read(): List<ArticleModel> {
        return detailLocalSource.read().map { it.toDomain() }
    }

    override suspend fun update(model: ArticleModel) {
        detailLocalSource.update(model.toEntity())
    }

    override suspend fun delete(model: ArticleModel) {
        detailLocalSource.delete(model.toEntity())
    }

}