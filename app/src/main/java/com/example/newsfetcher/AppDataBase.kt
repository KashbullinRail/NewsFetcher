package com.example.newsfetcher

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.newsfetcher.feature.bookmarks_screen.data.model.BookmarkEntity
import com.example.newsfetcher.feature.bookmarks_screen.data.model.BookmarksDao
import com.example.newsfetcher.feature.source_bookmarks_screen.data.model.SourceBookmarkEntity
import com.example.newsfetcher.feature.source_bookmarks_screen.data.model.SourceBookmarksDao


@Database(entities = [BookmarkEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun bookmarksDao(): BookmarksDao
}

@Database(entities = [SourceBookmarkEntity::class], version = 1)
abstract class AppSourceDataBase : RoomDatabase() {
    abstract fun sourceBookmarksDao(): SourceBookmarksDao
}
