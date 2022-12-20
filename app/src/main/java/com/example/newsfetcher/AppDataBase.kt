package com.example.newsfetcher

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.newsfetcher.feature.bookmarks.data.local.BookmarksDao
import com.example.newsfetcher.feature.bookmarks.data.local.model.BookmarkEntity


@Database(entities = [BookmarkEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun bookmarksDao(): BookmarksDao

}