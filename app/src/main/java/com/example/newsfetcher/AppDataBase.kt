package com.example.newsfetcher

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.newsfetcher.feature.bookmarks_screen.data.model.BookmarkEntity
import com.example.newsfetcher.feature.bookmarks_screen.data.model.BookmarksDao


@Database(entities = [BookmarkEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun bookmarksDao(): BookmarksDao

}
