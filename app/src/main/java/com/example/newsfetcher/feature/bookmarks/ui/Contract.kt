package com.example.newsfetcher.feature.bookmarks.ui

import com.example.newsfetcher.base.Event
import com.example.newsfetcher.feature.domian.ArticleModel

data class ViewState(
    val bookmarksArticle: List<ArticleModel>
)

sealed class UIEvent()
sealed class DataEvent() : Event {

    object LoadBookmarks : DataEvent()
    data class OnSuccessBookmarksLoaded(val bookmarksArticle: List<ArticleModel>) : DataEvent()
    data class OnFailedBookmarksLoaded(val throwable: Throwable) : DataEvent()
}