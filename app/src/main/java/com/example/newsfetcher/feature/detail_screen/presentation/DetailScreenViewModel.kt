package com.example.newsfetcher.feature.detail_screen.presentation

import com.example.newsfetcher.base.BaseViewModel
import com.example.newsfetcher.base.Event
import com.example.newsfetcher.feature.main_screen.domian.ArticleModel


class DetailScreenViewModel : BaseViewModel<ViewState>() {

    init {
        processDataEvent(DataEvent.LoadDetail)
    }

    override fun initialViewState(): ViewState =
        ViewState(
            state = State.Load,
            articleDetail = ArticleModel(
                "", "", "", "", "", "",
                "", "", "", false
            ),
        )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UIEvent.OnDetailArticleGet -> {
                return previousState.copy(
                    articleDetail = event.detailArticle,
                    state = State.Content
                )
            }
            else -> return null
        }
    }

}


