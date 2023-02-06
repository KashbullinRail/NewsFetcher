package com.example.newsfetcher.feature.favourite_news_setting_screen.presentation

import com.example.newsfetcher.base.Event


enum class State {
    Load,
    Content,
    Error
}

enum class FavouriteNews(
    val str: String
) {
    business("business"),
    entertaiment("entertaiment"),
    general("general"),
    health("health"),
    science("science"),
    sports("sports"),
    technology("technology")
}


data class ViewState(
    val state: State,
    val favouriteNews: String
//    val business: Boolean,
//    val entertainment: Boolean,
//    val general: Boolean,
//    val health: Boolean,
//    val science: Boolean,
//    val sports: Boolean,
//    val technology: Boolean
)

sealed class UIEvent : Event {
    object OnBusinessClicked : UIEvent()
    object OnEntertainmentClicked : UIEvent()
    object OnGeneralClicked : UIEvent()
    object OnHealthClicked : UIEvent()
    object OnScienceClicked : UIEvent()
    object OnSportsClicked : UIEvent()
    object OnTechnologyClicked : UIEvent()
    object OnSetFavouriteNewsSettingClicked : UIEvent()
}

sealed class DateEvent : Event {
    object LoadFavouriteNewsSetting : DateEvent()
}
