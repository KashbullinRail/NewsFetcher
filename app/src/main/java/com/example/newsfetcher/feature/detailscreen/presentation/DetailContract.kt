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
    val articleDetail: ArticleModel
)

sealed class UIEvent: Event {
}

sealed class DataEvent(): Event {

    object LoadBookmarks : DataEvent()
    data class OnSuccessBookmarksLoaded(val bookmarksArticle: List<ArticleModel>) : DataEvent()
    data class OnFailedBookmarksLoaded(val throwable: Throwable) : DataEvent()
    data class OnSuccesDetailLoad(val articleDetail: ArticleModel): DataEvent()

}