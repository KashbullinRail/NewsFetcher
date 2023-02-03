package com.example.newsfetcher.feature.search_setting_screen.presentation

import com.example.newsfetcher.base.Event


enum class State {
    Load,
    Content,
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

enum class DateType(
    val str: String
){
    DATE_FROM("date_from"),
    DATE_TO("date_to"),
    DATE_ALL("all_in")
}

data class ViewState(
    val state: State,
    val dataFrom: String,
    val dataTo: String,
    val searchIn: String,
    val sortBy: String,
    val dataType: String
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
    object LoadSearchSetting: DateEvent()
}
