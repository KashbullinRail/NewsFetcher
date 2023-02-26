package com.example.newsfetcher.feature.source_bookmarks_screen.data

import com.example.newsfetcher.feature.source_bookmarks_screen.data.model.SourceBookmarkEntity
import com.example.newsfetcher.feature.source_bookmarks_screen.data.model.SourceBookmarksDao


class SourceBookmarksLocalSource(private val sourceBookmarksDao: SourceBookmarksDao) {

    suspend fun create(entity: SourceBookmarkEntity) {
        sourceBookmarksDao.create(entity)
    }

    suspend fun read(): List<SourceBookmarkEntity> {
        return sourceBookmarksDao.read()
    }

    suspend fun update(entity: SourceBookmarkEntity) {
        sourceBookmarksDao.update(entity)
    }

    suspend fun delete(entity: SourceBookmarkEntity) {
        sourceBookmarksDao.delete(entity)
    }

}