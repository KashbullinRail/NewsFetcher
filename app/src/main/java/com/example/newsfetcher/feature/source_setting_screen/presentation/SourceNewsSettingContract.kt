package com.example.newsfetcher.feature.source_setting_screen.presentation

import com.example.newsfetcher.base.Event


enum class State {
    Load,
    Content,
    Error
}

enum class SourceNews(
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

enum class LanguageNews(
    val str: String
) {
    english("en"),
    russia("ru")
}

data class ViewState(
    val state: State,
    val sourceNews: String,
    val languageNews: String
)

sealed class UIEvent : Event {
    object OnBusinessClicked : UIEvent()
    object OnEntertainmentClicked : UIEvent()
    object OnGeneralClicked : UIEvent()
    object OnHealthClicked : UIEvent()
    object OnScienceClicked : UIEvent()
    object OnSportsClicked : UIEvent()
    object OnTechnologyClicked : UIEvent()
    object OnEnglishLanguageClicked: UIEvent()
    object OnRussiaLanguageClicked: UIEvent()
    object OnSetFavouriteNewsSettingClicked : UIEvent()
}

sealed class DateEvent : Event {
    object LoadFavouriteNewsSetting : DateEvent()
}
