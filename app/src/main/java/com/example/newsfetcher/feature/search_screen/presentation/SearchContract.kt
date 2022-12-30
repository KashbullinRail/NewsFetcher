package com.example.newsfetcher.feature.search_screen.presentation

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
    val isSearchEnabled: Boolean,
    val articlesShown: List<ArticleModel>,
    val articlesList: List<ArticleModel>,
    val searchText: String,
)

sealed class UIEvent : Event {
    data class OnArticleClicked(val index: Int) : UIEvent()
    data class OnSearchButtonClicked(val searchText: String) : UIEvent()
    data class OnSearchEdit(val text: String) : UIEvent()
}

sealed class DateEvent : Event {
    data class LoadArticles(val searchText: String) : DateEvent()
    data class OnLoadArticlesSucceed(val articles: List<ArticleModel>) : DateEvent()
}