package com.example.newsfetcher.feature.news_source_screen.presentation

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.newsfetcher.base.BaseViewModel
import com.example.newsfetcher.base.Event
import com.example.newsfetcher.feature.news_source_screen.domain.SourceModel
import com.example.newsfetcher.feature.news_source_screen.domain.SourcesInteractor
import com.example.newsfetcher.feature.source_bookmarks_screen.domain.SourceBookmarksInteractor
import kotlinx.coroutines.launch


class NewsSourceScreenViewModel(
    private val sourcesInteractor: SourcesInteractor,
    private val sourceBookmarksInteractor: SourceBookmarksInteractor
) : BaseViewModel<ViewState>() {

    init {
        processDataEvent(DateEvent.LoadSources)
    }

    override fun initialViewState() = ViewState(
        state = State.Load,
        sourceList = emptyList(),
        sourceListShown = emptyList(),
        sourceDetail = SourceModel(
            "", "", "", "", false
        ),
        webViewLink = ""
    )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is DateEvent.LoadSources -> {
                viewModelScope.launch {
                    sourcesInteractor.getSources().fold(
                        onError = {
                            Log.e("ERROR", it.localizedMessage)
                        },
                        onSuccess = {
                            processDataEvent(DateEvent.OnLoadSourcesSucceed(it))
                        }
                    )
                }
                return null
            }
            is DateEvent.OnLoadSourcesSucceed -> {
                return previousState.copy(
                    sourceList = event.sourcesList,
                    sourceListShown = event.sourcesList,
                    state = State.Content
                )
            }
            is UIEvent.OnSourcesClicked -> {
                when (event.type) {
                    SOURCE_ITEM -> {
                        return previousState.copy(
                            sourceDetail = previousState.sourceListShown[event.index],
                            state = State.LoadWebView
                        )
                    }
                    STAR_EMPTY -> {
                        event.type
                        viewModelScope.launch {
                            sourceBookmarksInteractor
                                .create(previousState.sourceListShown[event.index])
                        }
                        return previousState.copy(
                            sourceList = previousState.sourceList,
                            sourceListShown = previousState.sourceListShown,
                            state = State.Content
                        )
                    }
                    STAR_FULL -> {
                        viewModelScope.launch {
                            sourceBookmarksInteractor
                                .delete(previousState.sourceListShown[event.index])
                        }
                        return previousState.copy(
                            sourceList = previousState.sourceList,
                            sourceListShown = previousState.sourceListShown,
                            state = State.Content
                        )
                    }
                }
                return null
            }
            else -> return null
        }
    }

}