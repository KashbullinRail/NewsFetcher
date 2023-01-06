package com.example.newsfetcher.feature.search_setting_screen.data.model

import com.example.newsfetcher.feature.search_setting_screen.data.SettingDataStoreSource
import com.example.newsfetcher.feature.search_setting_screen.data.SearchSettingRepository


class SettingDataStoreRepositoryImpl(private val source: SettingDataStoreSource): SearchSettingRepository {

    override suspend fun getSettings(): DataStoreSettingModel {
        TODO("Not yet implemented")
    }

}