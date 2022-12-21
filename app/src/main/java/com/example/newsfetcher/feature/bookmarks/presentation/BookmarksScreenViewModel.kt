package com.example.newsfetcher.feature.bookmarks.presentation

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.newsfetcher.base.BaseViewModel
import com.example.newsfetcher.base.Event
import com.example.newsfetcher.feature.bookmarks.domian.BookmarksInteractor
import com.example.newsfetcher.feature.main_screen.domian.ArticleModel
import kotlinx.coroutines.launch


class BookmarksScreenViewModel(private val interactor: BookmarksInteractor) :
    BaseViewModel<ViewState>() {

    init {
        processDataEvent(DataEvent.LoadBookmarks)
    }

    override fun initialViewState(): ViewState =
        ViewState(
            state = State.Load,
            bookmarksArticle = emptyList(),
            articleDetail = ArticleModel(
                "2", "2", "2", "2", "2", "2"
            )
        )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {

        when (event) {
            is DataEvent.LoadBookmarks -> {
                viewModelScope.launch {
                    interactor.read().fold(
                        onError = {},
                        onSuccess = {
                            processDataEvent(DataEvent.OnSuccessBookmarksLoaded(it))
                        }
                    )
                }
                return null
            }
            is DataEvent.OnSuccessBookmarksLoaded -> {
                Log.d("Room", "articleBookmark = ${event.bookmarksArticle}")
                return previousState.copy(
                    bookmarksArticle = event.bookmarksArticle,
                    state = State.Content
                )
            }
            is UIEvent.OnArticleClicked -> {
                return previousState.copy(
                    articleDetail = previousState.bookmarksArticle[event.index],
                    state = State.LoadDetail
                )
            }
//            is DataEvent.OnSuccesDetailLoad -> {
//                Log.d("TAGG8", "Articles book ${liveDataDetail.value}")
//                return previousState.copy(
//                    articleDetail = event.articleDetail,
//                    state = State.LoadDetail
//                )
//            }
            else -> return null
        }

    }

}


