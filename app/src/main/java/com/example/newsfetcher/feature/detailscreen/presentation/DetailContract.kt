package com.example.newsfetcher.feature.detailscreen.presentation

import com.example.newsfetcher.base.Event
import com.example.newsfetcher.feature.main_screen.domian.ArticleModel


enum class State {
    Load,
    Content,
    Error
}

data class ViewState(
    val state: State,
    val articleDetail: ArticleModel,
    val articleDetailList: List<ArticleModel>
)

sealed class UIEvent : Event {
    object OnDeleteClicked : UIEvent()
}

sealed class DataEvent() : Event {
    object LoadDetail : DataEvent()
    data class OnSuccessDetailsLoaded(val articleDetailList: List<ArticleModel>) : DataEvent()
}