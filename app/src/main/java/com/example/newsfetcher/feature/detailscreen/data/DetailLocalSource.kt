package com.example.newsfetcher.feature.detailscreen.data

import com.example.newsfetcher.feature.bookmarks.data.model.BookmarksDao
import com.example.newsfetcher.feature.bookmarks.data.model.BookmarkEntity


class DetailLocalSource(private val bookmarksDao: BookmarksDao) {

    suspend fun create(entity: BookmarkEntity) {
        bookmarksDao.create(entity)
    }

    suspend fun read(): List<BookmarkEntity> {
        return bookmarksDao.read()
    }

    suspend fun update(entity: BookmarkEntity) {
        bookmarksDao.update(entity)
    }

    suspend fun delete(entity: BookmarkEntity) {
        bookmarksDao.delete(entity)
    }

}