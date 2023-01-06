package com.example.newsfetcher.feature.search_setting_screen.data.model



data class DataStoreSettingModel(
    val searchArea: String,
    val sources: String,
    val dataFrom: String,
    val dataTo: String,
    val language: String,
    val sortBy: String,
    val pageNumbers: String
)