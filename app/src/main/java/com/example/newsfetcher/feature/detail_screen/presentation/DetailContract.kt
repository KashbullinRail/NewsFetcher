package com.example.newsfetcher.feature.detail_screen.presentation

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
)

sealed class UIEvent : Event {
    data class OnDetailArticleGet(val detailArticle: ArticleModel) : UIEvent()
}

sealed class DataEvent() : Event {
    object LoadDetail : DataEvent()
}