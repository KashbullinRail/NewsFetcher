package com.example.newsfetcher.feature.source_bookmarks_screen.presentation

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
    val bookmarksSource: List<SourceModel>,
    val sourceInfo: SourceModel,
)

sealed class UIEvent: Event {
    data class OnSourceClicked(val index: Int, val type: String): UIEvent()
}

sealed class DataEvent() : Event {
    object LoadSourceBookmarks : DataEvent()
    data class OnSuccessSourceBookmarksLoaded(val bookmarksSource: List<SourceModel>) : DataEvent()
}