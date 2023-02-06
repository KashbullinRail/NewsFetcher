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
    Title("title"),
    Discription("description"),
    All_In("title,description,content")
}

enum class SortBy(
    val str: String
){
    Relevancy("relevancy"),
    Popularity("popularity"),
    PublishedAt("publishedAt")
}

enum class DateType(
    val str: String
){
    Date_From("date_from"),
    Date_To("date_to"),
    Date_All("all_in")
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
