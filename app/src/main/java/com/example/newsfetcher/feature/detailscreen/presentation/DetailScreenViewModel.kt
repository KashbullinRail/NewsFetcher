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
    private val detailInteractor: DetailInteractor,
    private val bookmarksInteractor: BookmarksInteractor
) : BaseViewModel<ViewState>() {

    init {
        processDataEvent(DataEvent.LoadDetail)
    }

    override fun initialViewState(): ViewState =
        ViewState(
            state = State.Load,
            articleDetailList = emptyList(),
            articleDetail = ArticleModel(
                "", "", "", "", "", "", "", "", ""
            ),
        )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {

        when (event) {
            is DataEvent.LoadDetail -> {
                viewModelScope.launch {
                    detailInteractor.read().fold(
                        onError = {
                            Log.e("ERROR", it.localizedMessage)
                        },
                        onSuccess = {
                            processDataEvent(DataEvent.OnSuccessDetailsLoaded(it))
                        }
                    )
                }
                return null
            }
            is DataEvent.OnSuccessDetailsLoaded -> {
                Log.d("RoomDetail", "articleBookmark = ${event.articleDetailList}")
                return if (event.articleDetailList.isNotEmpty()) {
                    previousState.copy(
                        articleDetail = event.articleDetailList.last(),
                        state = State.Content
                    )
                } else {
                    previousState.copy(
                        state = State.Content
                    )
                }
            }
            else -> return null

        }

    }

}


