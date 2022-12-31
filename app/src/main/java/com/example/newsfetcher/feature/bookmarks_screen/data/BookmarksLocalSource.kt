package com.example.newsfetcher.feature.bookmarks_screen.data

import com.example.newsfetcher.feature.bookmarks_screen.data.model.BookmarksDao
import com.example.newsfetcher.feature.bookmarks_screen.data.model.BookmarkEntity


class BookmarksLocalSource(private val bookmarksDao: BookmarksDao) {

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