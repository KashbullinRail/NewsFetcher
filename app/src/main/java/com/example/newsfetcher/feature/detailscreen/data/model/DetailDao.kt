package com.example.newsfetcher.feature.detailscreen.data.model

import androidx.room.*
import com.example.newsfetcher.feature.detailscreen.di.DETAIL_TABLE


@Dao
interface DetailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun create(entity: DetailEntity)

    @Query("SELECT*FROM $DETAIL_TABLE")
    suspend fun read(): List<DetailEntity>

    @Update
    suspend fun update(entity: DetailEntity)

    @Delete
    suspend fun delete(entity: DetailEntity)

}