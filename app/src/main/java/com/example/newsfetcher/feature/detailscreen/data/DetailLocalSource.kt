package com.example.newsfetcher.feature.detailscreen.data

import com.example.newsfetcher.feature.detailscreen.data.model.DetailDao
import com.example.newsfetcher.feature.detailscreen.data.model.DetailEntity


class DetailLocalSource(private val detailDao: DetailDao) {

    suspend fun create(entity: DetailEntity) {
        detailDao.create(entity)
    }

    suspend fun read(): List<DetailEntity> {
        return detailDao.read()
    }

    suspend fun update(entity: DetailEntity) {
        detailDao.update(entity)
    }

    suspend fun delete(entity: DetailEntity) {
        detailDao.delete(entity)
    }

}