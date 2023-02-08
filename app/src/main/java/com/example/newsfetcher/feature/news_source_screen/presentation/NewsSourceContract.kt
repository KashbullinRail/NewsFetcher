package com.example.newsfetcher.feature.news_source_screen.presentation

import com.example.newsfetcher.base.Event
import com.example.newsfetcher.feature.news_source_screen.domain.SourceModel


enum class State {
    Load,
    Content,
    LoadWebView,
    Error
}

data class ViewState(
    val state: State,
    val sourceListShown: List<SourceModel>,
    val webViewLink: String
)

sealed class UIEvent : Event {
    data class OnSourcesClicked(val index: Int, val type: String) : UIEvent()
    data class OnWebViewLink(val webViewLink: String) : UIEvent()
}

sealed class DateEvent : Event {
    object LoadSources : DateEvent()
    data class OnLoadSourcesSucceed(val sourcesList: List<SourceModel>) : DateEvent()
}