package com.example.newsfetcher.feature.search_screen.data.model

data class SearchSettingModel(
    val searchIn: String,
    val dateFrom: String,
    val dateTo: String,
    val sortBy: String
)

data class SearchSettingMapModel(
    val searchSettingMapModel: SearchSettingMapModel
)
