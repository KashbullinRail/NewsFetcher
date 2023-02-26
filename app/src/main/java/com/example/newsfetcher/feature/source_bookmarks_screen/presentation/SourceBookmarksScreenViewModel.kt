package com.example.newsfetcher.feature.source_bookmarks_screen.presentation

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.newsfetcher.base.BaseViewModel
import com.example.newsfetcher.base.Event
import com.example.newsfetcher.feature.news_source_screen.domain.SourceModel
import com.example.newsfetcher.feature.source_bookmarks_screen.domain.SourceBookmarksInteractor
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SourceBookmarksScreenViewModel(
    private val sourceBookmarksInteractor: SourceBookmarksInteractor
) : BaseViewModel<ViewState>() {

    init {
        processDataEvent(DataEvent.LoadSourceBookmarks)
    }

    override fun initialViewState(): ViewState =
        ViewState(
            state = State.Load,
            bookmarksArticle = emptyList(),
            articleDetail = SourceModel(
                "", "", "", "", false
            ),
        )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {

        when (event) {
            is DataEvent.LoadSourceBookmarks -> {
                viewModelScope.launch {
                    sourceBookmarksInteractor.read().fold(
                        onError = {
                            Log.e("ERROR", it.localizedMessage)
                        },
                        onSuccess = {
                            processDataEvent(DataEvent.OnSuccessSourceBookmarksLoaded(it))
                        }
                    )
                }
                return null
            }
            is DataEvent.OnSuccessSourceBookmarksLoaded -> {
                return previousState.copy(
                    bookmarksArticle = event.bookmarksSource,
                    state = State.Content
                )
            }
            is UIEvent.OnArticleClicked -> {
                when (event.type) {
                    SOURCE_BOOKMARK_ITEM -> {
                        return previousState.copy(
                            articleDetail = previousState.bookmarksArticle[event.index],
                            state = State.DetailLoad
                        )
                    }
                    SOURCE_BOOKMARK_DELETE -> {
                        viewModelScope.launch {
                            sourceBookmarksInteractor.delete(
                                previousState.bookmarksArticle[event.index]
                            )
                        }
                        viewModelScope.launch {
                            delay(500)
                            sourceBookmarksInteractor.read().fold(
                                onError = {
                                    Log.e("ERROR", it.localizedMessage)
                                },
                                onSuccess = {
                                    processDataEvent(DataEvent.OnSuccessSourceBookmarksLoaded(it))
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


