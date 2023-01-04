package com.example.newsfetcher.feature.search_screen.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.activity.addCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newsfetcher.R
import com.example.newsfetcher.base.focusAndShowKeyboard
import com.example.newsfetcher.base.hideKeyboard
import com.example.newsfetcher.databinding.FragmentSearchScreenBinding
import com.example.newsfetcher.feature.main_screen.news.presentation.MainArticleAdapter
import com.example.newsfetcher.feature.main_screen.presentation.PUT_TO_DETAIL_FRAGMENT
import com.example.newsfetcher.feature.search_screen.data.SearchArticlesRemoteSource
import org.koin.androidx.viewmodel.ext.android.viewModel


class SearchScreenFragment : Fragment(R.layout.fragment_search_screen){

    private val binding by viewBinding(FragmentSearchScreenBinding::bind)

    private val viewModel: SearchScreenViewModel by viewModel()

    private val adapter: MainArticleAdapter by lazy {
        MainArticleAdapter { index, type ->
            viewModel.processUIEvent(UIEvent.OnArticleClicked(index, type))
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.viewState.observe(viewLifecycleOwner, ::render)

        with(binding) {

            etTitleSearch.focusAndShowKeyboard()

            rvArticlesSearch.adapter = adapter

            bnvBarSearch.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.itemBookmarks -> {
                        findNavController().navigate(R.id.bookmarksFragment)
                    }
                    R.id.itemMain -> {
                        findNavController().navigate(R.id.mainScreenFragment)
                    }
                    else -> {}
                }
                true
            }
            bnvBarSearch.selectedItemId = R.id.itemSearch

            etTitleSearch.setOnEditorActionListener { _, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    requireActivity().hideKeyboard()
                    val text = etTitleSearch.text.toString().trim()
                    SearchArticlesRemoteSource.qqq = text //TODO implement via interface
                    viewModel.processUIEvent(UIEvent.OnSearchButtonClicked(text))
                }
                true
            }

            ivSearchBotton.setOnClickListener {
                requireActivity().hideKeyboard()
                val text = etTitleSearch.text.toString().trim()
               SearchArticlesRemoteSource.qqq = text //TODO implement via interface
                viewModel.processUIEvent(UIEvent.OnSearchButtonClicked(text))
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            findNavController().navigate(R.id.bookmarksFragment)
        }


    }

    private fun render(viewState: ViewState) {

        when (viewState.state) {
            State.Load -> {
            }
            State.Content -> {
                adapter.setData(viewState.articlesSearchShown)
            }
            State.Error -> {
            }
            State.DetailLoad -> {
                val articleDetail = viewState.articleDetail
                Log.d("TAGG", "Detail SearchScreenFragment = ${viewState.articleDetail}")
                //TODO redirect data transfer to safeArgs
                val bundle = bundleOf(PUT_TO_DETAIL_FRAGMENT to articleDetail)
                findNavController().navigate(R.id.detailFragment, bundle)
            }
        }

    }

}