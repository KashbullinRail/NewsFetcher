package com.example.newsfetcher.feature.search_screen.presentation

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.newsfetcher.base.BaseViewModel
import com.example.newsfetcher.base.Event
import com.example.newsfetcher.feature.bookmarks_screen.domian.BookmarksInteractor
import com.example.newsfetcher.feature.search_screen.domain.SearchInteractor
import kotlinx.coroutines.launch

class SearchScreenViewModel(
    private val searchInteractor: SearchInteractor,
    private val bookmarksInteractor: BookmarksInteractor
) : BaseViewModel<ViewState>() {

    init {
        processDataEvent(DateEvent.LoadArticles)
    }

    override fun initialViewState() = ViewState(
        state = State.Load,
        articlesList = emptyList(),
        articlesShown = emptyList(),
        isSearchEnabled = false
    )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {

        when (event) {
            is DateEvent.LoadArticles -> {
                viewModelScope.launch {
                    searchInteractor.getArticles().fold(
                        onError = {
                            Log.e("ERROR", it.localizedMessage)
                        },
                        onSuccess = {
                            processDataEvent(DateEvent.OnLoadArticlesSucceed(it))
                        }
                    )
                }
                return null
            }
            is DateEvent.OnLoadArticlesSucceed -> {

                return previousState.copy(
                    articlesList = event.articles,
                    articlesShown = event.articles,
                    state = State.Content
                )
            }
            is UIEvent.OnArticleClicked -> {
                viewModelScope.launch {
                    bookmarksInteractor.create(previousState.articlesShown[event.index])
                    State.DetailLoad
                }
                return null
            }
            is UIEvent.OnSearchButtonCliked -> {
                return previousState.copy(
                    articlesShown = if (!previousState.isSearchEnabled) previousState.articlesList
                    else previousState.articlesShown,
                    isSearchEnabled = !previousState.isSearchEnabled
                )
            }
            is UIEvent.OnSearchEdit -> {
                return previousState.copy(articlesShown = previousState.articlesList.filter {
                    it.title.contains(
                        event.text
                    )
                }
                )
            }
            else -> return null
        }

    }
}