package com.example.newsfetcher.feature.bookmarks.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsfetcher.base.BaseViewModel
import com.example.newsfetcher.base.Event
import com.example.newsfetcher.feature.bookmarks.domian.BookmarksInteractor
import kotlinx.coroutines.launch

class BookmarksScreenViewModel(private val interactor: BookmarksInteractor): BaseViewModel<ViewState>() {

    init {
        processDataEvent(DataEvent.LoadBookmarks)
    }

    override fun initialViewState(): ViewState = ViewState(bookmarksArticle = emptyList())
    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        when(event){
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
                return previousState.copy(bookmarksArticle =  event.bookmarksArticle)
            }
            else -> return null
        }

    }
}


