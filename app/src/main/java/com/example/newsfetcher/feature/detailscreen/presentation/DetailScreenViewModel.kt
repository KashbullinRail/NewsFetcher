package com.example.newsfetcher.feature.detailscreen.presentation

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.newsfetcher.base.BaseViewModel
import com.example.newsfetcher.base.Event
import com.example.newsfetcher.feature.bookmarks.domian.BookmarksInteractor
import com.example.newsfetcher.feature.detailscreen.domain.DetailInteractor
import com.example.newsfetcher.feature.main_screen.domian.ArticleModel
import kotlinx.coroutines.launch


class DetailScreenViewModel(
    private val interactor: DetailInteractor,
    private val bookmarksInteractor: BookmarksInteractor
) :
    BaseViewModel<ViewState>() {

    init {
        processDataEvent(DataEvent.LoadBookmarks)
    }

    override fun initialViewState(): ViewState =
        ViewState(
            state = State.Load,
            articleDetail = ArticleModel(
                "2", "2", "2", "2", "2", "2"
            ),
            articleDetailList = emptyList()
        )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {

        when (event) {
            is DataEvent.LoadBookmarks -> {
                viewModelScope.launch {
                    interactor.read().fold(
                        onError = {},
                        onSuccess = {
                            processDataEvent(DataEvent.OnSuccessDetailsLoaded(it))
                        }
                    )
                }
                return null
            }
            is DataEvent.OnSuccessDetailsLoaded -> {
                Log.d("Room2", "articleBookmark = ${event.articleDetailList}")
                val articleDetail = event.articleDetailList.last()
                return previousState.copy(
                    articleDetail = articleDetail,
                    state = State.Content
                )
            }

            else -> return null
        }

    }

}

