package com.example.newsfetcher

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.newsfetcher.feature.bookmarks.data.model.BookmarksDao
import com.example.newsfetcher.feature.bookmarks.data.model.BookmarkEntity
import com.example.newsfetcher.feature.detailscreen.data.model.DetailDao
import com.example.newsfetcher.feature.detailscreen.data.model.DetailEntity


@Database(entities = [BookmarkEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun bookmarksDao(): BookmarksDao

}

@Database(entities = [DetailEntity::class], version = 1)
abstract class AppDataBaseDetail : RoomDatabase() {

    abstract fun detailDao(): DetailDao

}