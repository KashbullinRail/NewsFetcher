package com.example.newsfetcher.feature.source_bookmarks_screen.data.model

import androidx.room.*


@Dao
interface SourceBookmarksDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun create(entity: SourceBookmarkEntity)

    @Query("SELECT*FROM $SOURCE_BOOKMARKS_TABLE")
    suspend fun read(): List<SourceBookmarkEntity>

    @Update
    suspend fun update(entity: SourceBookmarkEntity)

    @Delete
    suspend fun delete(entity: SourceBookmarkEntity)

}