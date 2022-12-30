package com.example.newsfetcher.feature.search_screen.presentation

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.newsfetcher.base.BaseViewModel
import com.example.newsfetcher.base.Event
import com.example.newsfetcher.feature.bookmarks_screen.domian.BookmarksInteractor
import com.example.newsfetcher.feature.main_screen.domian.ArticleModel
import com.example.newsfetcher.feature.main_screen.presentation.ARTICLE_ITEM
import com.example.newsfetcher.feature.main_screen.presentation.BOOKMARK_EMPTY
import com.example.newsfetcher.feature.main_screen.presentation.BOOKMARK_FULL
import com.example.newsfetcher.feature.search_screen.data.SearchArticlesRemoteSource
import com.example.newsfetcher.feature.search_screen.domain.SearchInteractor
import kotlinx.coroutines.launch


class SearchScreenViewModel(
    private val searchInteractor: SearchInteractor,
    private val bookmarksInteractor: BookmarksInteractor
) : BaseViewModel<ViewState>() {

    init {
        processDataEvent(DateEvent.LoadArticles(""))
    }

    override fun initialViewState() = ViewState(
        state = State.Load,
        articlesList = emptyList(),
        articlesShown = emptyList(),
        articleDetail = ArticleModel(
            "", "", "", "", "",
            "", "", "", false
        ),
        searchText = ""
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
                when (event.type) {
                    ARTICLE_ITEM -> {
                        return previousState.copy(
                            articleDetail = previousState.articlesShown[event.index],
                            state = State.DetailLoad
                        )
                    }
                    BOOKMARK_EMPTY -> {
                        viewModelScope.launch {
                            bookmarksInteractor.create(previousState.articlesShown[event.index])
                        }
                        return previousState.copy(
                            articlesList = previousState.articlesList,
                            articlesShown = previousState.articlesShown,
                            state = State.Content
                        )
                    }
                    BOOKMARK_FULL -> {
                        viewModelScope.launch {
                            bookmarksInteractor.delete(previousState.articlesShown[event.index])
                        }
                        return previousState.copy(
                            articlesList = previousState.articlesList,
                            articlesShown = previousState.articlesShown,
                            state = State.Content
                        )
                    }
                }
                return null
            }
            is UIEvent.OnSearchButtonClicked -> {
                SearchArticlesRemoteSource.qqq = event.searchText
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
                State.Content
                return previousState.copy(searchText = event.searchText)
            }
            else -> return null
        }

    }

}