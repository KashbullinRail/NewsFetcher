package com.example.newsfetcher.feature.mainscreen

import android.app.usage.UsageEvents
import com.example.newsfetcher.base.Event
import com.example.newsfetcher.feature.domian.ArticleModel

data class ViewState(
    val articles: List<ArticleModel>
)

sealed class DateEvent: Event{
    object LoadArticles: DateEvent()
    data class OnLoadArticlesSucceed(val articles: List<ArticleModel>): DateEvent()
}