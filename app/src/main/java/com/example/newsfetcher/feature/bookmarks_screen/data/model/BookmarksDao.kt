package com.example.newsfetcher.feature.bookmarks_screen.data.model

import androidx.room.*


@Dao
interface BookmarksDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun create(entity: BookmarkEntity)

    @Query("SELECT*FROM $BOOKMARKS_TABLE")
    suspend fun read(): List<BookmarkEntity>

    @Update
    suspend fun update(entity: BookmarkEntity)

    @Delete
    suspend fun delete(entity: BookmarkEntity)

}