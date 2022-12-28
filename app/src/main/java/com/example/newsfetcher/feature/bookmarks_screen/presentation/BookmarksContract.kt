package com.example.newsfetcher.feature.bookmarks_screen.presentation

import com.example.newsfetcher.base.Event
import com.example.newsfetcher.feature.main_screen.domian.ArticleModel


enum class State {
    Load,
    Content,
    DetailLoad,
    Error
}

data class ViewState(
    val state: State,
    val bookmarksArticle: List<ArticleModel>,
    val articleDetail: ArticleModel
)

sealed class UIEvent: Event {
    data class OnArticleClicked(val index: Int): UIEvent()
    object OnDeleteClicked: UIEvent()
}

sealed class DataEvent() : Event {
    object LoadBookmarks : DataEvent()
    data class OnSuccessBookmarksLoaded(val bookmarksArticle: List<ArticleModel>) : DataEvent()
}