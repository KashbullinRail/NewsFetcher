package com.example.newsfetcher.feature.mainscreen

import android.app.usage.UsageEvents
import androidx.lifecycle.Lifecycle
import com.example.newsfetcher.base.Event
import com.example.newsfetcher.feature.domian.ArticleModel

enum class State {
    Load,
    Content,
    Error
}

data class ViewState(
    val state: State,
    val isSearchEnabled: Boolean,
    val articlesShown: List<ArticleModel>,
    val articlesList: List<ArticleModel>
)

sealed class UIEvent: Event{
    data class OnArticleClicked(val index: Int): UIEvent()
    object OnSearchButtonCliked : UIEvent()
    data class OnSearchEdit(val text: String): UIEvent()
}

sealed class DateEvent: Event{
    object LoadArticles: DateEvent()
    data class OnLoadArticlesSucceed(val articles: List<ArticleModel>): DateEvent()
}