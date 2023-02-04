package com.example.newsfetcher.feature.favourite_news_setting.presentation

import com.example.newsfetcher.base.Event


enum class State {
    Load,
    Content,
    Error
}


data class ViewState(
    val state: State,
    val business: Boolean,
    val entertainment: Boolean,
    val general: Boolean,
    val health: Boolean,
    val science: Boolean,
    val sports: Boolean,
    val technology: Boolean
)

sealed class UIEvent : Event {
    object OnSetFavouriteNewsSettingClicked: UIEvent()
    object OnBusinessClicked : UIEvent()
    object OnEntertainmentClicked : UIEvent()
    object OnGeneralClicked : UIEvent()
    object OnHealthClicked : UIEvent()
    object OnScienceClicked : UIEvent()
    object OnSportsClicked : UIEvent()
    object OnTechnologyClicked: UIEvent()
}

sealed class DateEvent : Event {
    object LoadFavouriteNewsSetting: DateEvent()
}
