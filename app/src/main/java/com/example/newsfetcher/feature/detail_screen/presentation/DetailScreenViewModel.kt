package com.example.newsfetcher.feature.detail_screen.presentation

import com.example.newsfetcher.base.BaseViewModel
import com.example.newsfetcher.base.Event
import com.example.newsfetcher.feature.main_screen.news.domian.ArticleModel


class DetailScreenViewModel : BaseViewModel<ViewState>() {

    init {
        processDataEvent(DataEvent.LoadDetail)
    }

    override fun initialViewState(): ViewState =
        ViewState(
            state = State.Load,
            detailArticle = ArticleModel(
                "", "", "", "", "", "",
                "", "", "", false
            ),
            webViewLink = ""
        )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UIEvent.OnDetailArticleGet -> {
                return previousState.copy(
                    detailArticle = event.detailArticle,
                    state = State.Content
                )
            }
            is UIEvent.OnWebViewLink -> {
                return previousState.copy(
                    webViewLink = event.webViewLink,
                    state = State.LoadWebView
                )
            }
            else -> return null
        }
    }

}


