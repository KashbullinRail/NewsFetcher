package com.example.newsfetcher.feature.main_screen.presentation

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.newsfetcher.base.BaseViewModel
import com.example.newsfetcher.base.Event
import com.example.newsfetcher.feature.bookmarks_screen.domian.BookmarksInteractor
import com.example.newsfetcher.feature.main_screen.domian.ArticleModel
import com.example.newsfetcher.feature.main_screen.domian.ArticlesInteractor
import kotlinx.coroutines.launch


class MainScreenViewModel(
    private val interactor: ArticlesInteractor,
    private val bookmarksInteractor: BookmarksInteractor
) : BaseViewModel<ViewState>() {

    init {
        processDataEvent(DateEvent.LoadArticles)
    }

    override fun initialViewState() = ViewState(
        state = State.Load,
        articlesList = emptyList(),
        articlesShown = emptyList(),
        articleDetail = ArticleModel(
            "", "", "", "", "", "", "", "", false
        ),
        isSearchEnabled = false,
        isBookmarkVisible = false
    )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {

        when (event) {
            is DateEvent.LoadArticles -> {
                viewModelScope.launch {
                    interactor.getArticles().fold(
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
                if (event.type == "item") {
                    return previousState.copy(
                        articleDetail = previousState.articlesShown[event.index],
                        state = State.DetailLoad
                    )
                }
                if (event.type == "bookmarks") {
                    viewModelScope.launch {
                        bookmarksInteractor.create(previousState.articlesShown[event.index])
                    }
                    Log.d("TAGG", "UIEvent visible 1 ${previousState.articlesShown[event.index].selectedBookmark}")
                    previousState.articlesShown[event.index].selectedBookmark = !previousState.isBookmarkVisible
                    Log.d("TAGG", "UIEvent visible 2 ${previousState.articlesShown[event.index].selectedBookmark}")
                    viewModelScope.launch {
                        bookmarksInteractor.update(previousState.articlesShown[event.index])
                    }
                    Log.d("TAGG", "UIEvent visible 3 ${previousState.articlesShown[event.index].selectedBookmark}")
                    return previousState.copy(
                        articleDetail = previousState.articlesShown[event.index],
                        isBookmarkVisible = !previousState.isBookmarkVisible,
                        state = State.AddBookmarks
                    )
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