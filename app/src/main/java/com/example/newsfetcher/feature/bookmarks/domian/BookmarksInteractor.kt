package com.example.newsfetcher.feature.bookmarks.domian

import com.example.newsfetcher.feature.bookmarks.data.local.BookmarksRepository
import com.example.newsfetcher.feature.bookmarks.data.toDomain
import com.example.newsfetcher.feature.bookmarks.data.toEntity
import com.example.newsfetcher.feature.domian.ArticleModel

class BookmarksInteractor(private val bookmarksRepository: BookmarksRepository){
    suspend fun create(model: ArticleModel) {
        bookmarksRepository.create(model)
    }

    suspend fun read(): List<ArticleModel> {
        return bookmarksRepository.read()
    }

    suspend fun update(model: ArticleModel) {
        bookmarksRepository.update(model)
    }

    suspend fun delete(model: ArticleModel) {
        bookmarksRepository.delete(model)
    }
}