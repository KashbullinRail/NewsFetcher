package com.example.newsfetcher.feature.search_setting_screen.presentation

import com.example.newsfetcher.base.Event
import com.example.newsfetcher.feature.search_setting_screen.data.model.DataStoreSettingModel


enum class State {
    Load,
    Content,
    DataPickerLoad,
    Error
}

data class ViewState(
    val state: State,
    val titleSearchIn: Boolean,
    val descriptionSearchIn: Boolean,
    val allSearchIn: Boolean,
    val relevancy: Boolean,
    val publishedAt: Boolean,
    val popularity: Boolean,
    val dataFrom: String,
    val dataTo: String
)

sealed class UIEvent : Event {
    object OnTitleSearchInClicked : UIEvent()
    object OnDescriptionSearchInClicked : UIEvent()
    object OnAllSearchInClicked : UIEvent()
    object OnRelevancyClicked : UIEvent()
    object OnPublishedAtClicked : UIEvent()
    object OnPopularityClicked : UIEvent()
    data class OnDataFromClicked(val dateFrom: String) : UIEvent()
    data class OnDataToClicked(val dateTo: String) : UIEvent()
}

sealed class DateEvent : Event {
    data class LoadArticles(val searchText: String) : DateEvent()
    data class OnLoadArticlesSucceed(val searchSetting: DataStoreSettingModel) : DateEvent()
}

enum class SearchIn {
    TitleSearch,
    DescriptionSearch,
    AllSearch
}