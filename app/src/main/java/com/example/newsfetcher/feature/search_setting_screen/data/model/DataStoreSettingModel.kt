package com.example.newsfetcher.feature.search_setting_screen.data.model


data class DataStoreSettingModel(
    val titleSearchIn: Boolean,
    val descriptionSearchIn: Boolean,
    val allSearchIn: Boolean,
    val relevancy: Boolean,
    val publishedAt: Boolean,
    val popularity: Boolean,
    val dataFrom: String,
    val dataTo: String
)