package com.example.newsfetcher.feature.search_setting_screen.presentation

import com.example.newsfetcher.base.Event
import com.example.newsfetcher.feature.search_setting_screen.data.model.DataStoreSettingModel
import com.example.newsfetcher.feature.search_setting_screen.presentation.date_set_screen.model.SearchSettingModel


enum class State {
    Load,
    ContentSearchIn,
    ContentSortBy,
    ContentDateFrom,
    ContentDateTo,
    Error
}

enum class SearchIn(
    val str: String
) {
    TITLE("title"),
    DISCRIPTION("description"),
    ALL_IN("title,description,content")
}

enum class SortBy(
    val str: String
){
    RELEVANCY("relevancy"),
    POPULARITY("popularity"),
    PUBLISHEDAT("publishedAt")
}

data class ViewState(
    val state: State,
    val dataFrom: String,
    val dataTo: String,
    val searchIn: String,
    val sortBy: String
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
    object OnSetSearchSettingClicked: UIEvent()
}

sealed class DateEvent : Event {
    // TODO implement state loading in the dialog box in the future
}
