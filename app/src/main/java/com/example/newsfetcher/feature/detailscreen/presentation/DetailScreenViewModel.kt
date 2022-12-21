package com.example.newsfetcher.feature.detailscreen.presentation

import android.util.Log
import com.example.newsfetcher.base.BaseViewModel
import com.example.newsfetcher.base.Event
import com.example.newsfetcher.feature.bookmarks.domian.BookmarksInteractor
import com.example.newsfetcher.feature.main_screen.domian.ArticleModel


class DetailScreenViewModel(private val interactor: BookmarksInteractor) :
    BaseViewModel<ViewState>() {

    init {
        processDataEvent(DataEvent.LoadBookmarks)
    }

    override fun initialViewState(): ViewState =
        ViewState(
            state = State.Load,
            articleDetail = ArticleModel(
                "1", "1", "1", "1", "1", "1"
            )
        )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {

        Log.d("TAGG11", "articleBookmark = ${viewState.value}")


        when (event) {
            is DataEvent.LoadBookmarks -> {

                return null
            }
            is DataEvent.OnSuccesDetailLoad -> {
                Log.d("TAGG10", "articleBookmark = ${event.articleDetail}")
                return previousState.copy(
                    state = State.Content
                )
            }
            else -> return null
        }

    }

}


