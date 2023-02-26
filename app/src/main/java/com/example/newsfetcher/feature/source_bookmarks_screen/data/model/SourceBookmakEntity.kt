package com.example.newsfetcher.feature.source_bookmarks_screen.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


const val SOURCE_BOOKMARKS_TABLE = "SOURCE_BOOKMARKS_TABLE"


@Entity(tableName = SOURCE_BOOKMARKS_TABLE)
data class SourceBookmarkEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "url")
    val url: String
)

