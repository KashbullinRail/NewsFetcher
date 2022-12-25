package com.example.newsfetcher.feature.bookmarks.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.newsfetcher.R
import com.example.newsfetcher.feature.main_screen.presentation.ArticlesAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.koin.androidx.viewmodel.ext.android.viewModel


class BookmarksFragment : Fragment(R.layout.fragment_bookmarks) {

    private val viewModel: BookmarksScreenViewModel by viewModel()

    private val recyclerView: RecyclerView by lazy {
        requireActivity().findViewById(R.id.rvBookmarkedArticles)
    }
    private val adapter: ArticlesAdapter by lazy {
        ArticlesAdapter { index ->
            viewModel.processUIEvent(UIEvent.OnArticleClicked(index))
        }
    }
    private val fabDeleteBookmarks: FloatingActionButton by lazy {
        requireActivity().findViewById(R.id.fabDeleteBookmarks) }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        lifecycleScope.launchWhenStarted {
//            viewModel.viewState.collect { state -> state?.let { this@BookmarksFragment::render } }
//        }

        viewModel.viewState.observe(viewLifecycleOwner, ::render)

        recyclerView.adapter = adapter

        fabDeleteBookmarks.setOnClickListener {
            viewModel.processUIEvent(UIEvent.OnDeleteClicked)
        }

    }

    private fun render(viewState: ViewState) {

        when (viewState.state) {
            State.Load -> {
            }
            State.Content -> {
                adapter.setData(viewState.bookmarksArticle)
            }
            State.Error -> {
            }
        }

    }

}