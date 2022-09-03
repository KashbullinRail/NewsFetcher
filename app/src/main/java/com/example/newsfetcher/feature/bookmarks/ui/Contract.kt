package com.example.newsfetcher.feature.bookmarks.ui

import com.example.newsfetcher.feature.domian.ArticleModel

data class ViewState(
    val bookmarksArticle: List<ArticleModel>
)

sealed class UIEvent()
sealed class DataEvent()