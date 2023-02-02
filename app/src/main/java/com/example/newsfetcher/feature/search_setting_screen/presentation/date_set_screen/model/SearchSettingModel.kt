package com.example.newsfetcher.feature.search_setting_screen.presentation.date_set_screen.model

data class SearchSettingModel(
    val searchIn: String,
    val dateFrom: String,
    val dateTo: String,
    val sortBy: String
)
