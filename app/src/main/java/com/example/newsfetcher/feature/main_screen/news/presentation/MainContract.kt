package com.example.newsfetcher.feature.main_screen.news.presentation

import com.example.newsfetcher.base.Event
import com.example.newsfetcher.feature.main_screen.news.data.ArticleModel


enum class State {
    Load,
    Content,
    DetailLoad,
    Error
}

data class ViewState(
    val state: State,
    val articlesShown: List<ArticleModel>,
    val articlesList: List<ArticleModel>,
    val articleDetail: ArticleModel
)

sealed class UIEvent : Event {
    data class OnArticleClicked(val index: Int, val type: String) : UIEvent()
}

sealed class DateEvent : Event {
    object LoadArticles : DateEvent()
    data class OnLoadArticlesSucceed(val articles: List<ArticleModel>) : DateEvent()
}