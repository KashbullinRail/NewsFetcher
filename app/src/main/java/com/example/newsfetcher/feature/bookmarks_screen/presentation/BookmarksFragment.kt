package com.example.newsfetcher.feature.bookmarks_screen.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newsfetcher.R
import com.example.newsfetcher.databinding.FragmentBookmarksBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class BookmarksFragment : Fragment(R.layout.fragment_bookmarks) {

    private val binding by viewBinding(FragmentBookmarksBinding::bind)

    private val viewModel: BookmarksScreenViewModel by viewModel()

    private val adapter: BookmarksAdapter by lazy {
        BookmarksAdapter { index, type ->
            viewModel.processUIEvent(UIEvent.OnArticleClicked(index, type))
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.viewState.observe(viewLifecycleOwner, ::render)

        with(binding) {

            rvBookmarkedArticles.adapter = adapter

            bnvBarBookmarks.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.itemMain -> {
                        findNavController().navigate(R.id.mainScreenFragment)
                    }
                    R.id.itemSearch -> {
                        findNavController().navigate(R.id.searchScreenFragment)
                    }
                    else -> {}
                }
                true
            }
            bnvBarBookmarks.selectedItemId = R.id.itemBookmarks

        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            findNavController().navigate(R.id.mainScreenFragment)
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
            State.DetailLoad -> {
                val articleDetail = viewState.articleDetail
                Log.d("TAGG", "UIEvent load = ${viewState.articleDetail}")
                val action = BookmarksFragmentDirections
                    .actionBookmarksFragmentToDetailFragment(articleDetail)
                findNavController().navigate(action)
            }
        }
    }

}