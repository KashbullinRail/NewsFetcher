package com.example.newsfetcher.feature.search_setting_screen.data

import com.example.newsfetcher.feature.search_setting_screen.data.model.DataStoreSettingModel


interface SearchSettingRepository {

    suspend fun getSettings(): DataStoreSettingModel

}