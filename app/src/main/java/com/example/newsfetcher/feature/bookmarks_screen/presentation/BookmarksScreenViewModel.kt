package com.example.newsfetcher.feature.bookmarks_screen.presentation

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.newsfetcher.base.BaseViewModel
import com.example.newsfetcher.base.Event
import com.example.newsfetcher.feature.bookmarks_screen.domian.BookmarksInteractor
import com.example.newsfetcher.feature.main_screen.news.domian.ArticleModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class BookmarksScreenViewModel(
    private val bookmarksInteractor: BookmarksInteractor
) : BaseViewModel<ViewState>() {

    init {
        processDataEvent(DataEvent.LoadBookmarks)
    }

    override fun initialViewState(): ViewState =
        ViewState(
            state = State.Load,
            bookmarksArticle = emptyList(),
            articleDetail = ArticleModel(
                "", "", "", "", "", "",
                "", "", "", false
            ),
        )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {

        when (event) {
            is DataEvent.LoadBookmarks -> {
                viewModelScope.launch {
                    bookmarksInteractor.read().fold(
                        onError = {
                            Log.e("ERROR", it.localizedMessage)
                        },
                        onSuccess = {
                            processDataEvent(DataEvent.OnSuccessBookmarksLoaded(it))
                        }
                    )
                }
                return null
            }
            is DataEvent.OnSuccessBookmarksLoaded -> {
                return previousState.copy(
                    bookmarksArticle = event.bookmarksArticle,
                    state = State.Content
                )
            }
            is UIEvent.OnArticleClicked -> {
                when (event.type) {
                    BOOKMARK_ITEM -> {
                        return previousState.copy(
                            articleDetail = previousState.bookmarksArticle[event.index],
                            state = State.DetailLoad
                        )
                    }
                    BOOKMARK_DELETE -> {
                        viewModelScope.launch {
                            bookmarksInteractor.delete(previousState.bookmarksArticle[event.index])
                        }
                        viewModelScope.launch {
                            delay(500)
                            bookmarksInteractor.read().fold(
                                onError = {
                                    Log.e("ERROR", it.localizedMessage)
                                },
                                onSuccess = {
                                    processDataEvent(DataEvent.OnSuccessBookmarksLoaded(it))
                                }
                            )
                        }
                    }
                }
                return null
            }
            else -> return null
        }

    }

}


