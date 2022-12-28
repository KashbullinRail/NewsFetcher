package com.example.newsfetcher.feature.search_screen.presentation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newsfetcher.R
import com.example.newsfetcher.databinding.FragmentNewsSearchBinding
import com.example.newsfetcher.feature.main_screen.presentation.ArticlesAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class SearchScreenFragment : Fragment(R.layout.fragment_news_search) {

    private val binding by viewBinding(FragmentNewsSearchBinding::bind)

    private val viewModel: SearchScreenViewModel by viewModel()

    private val adapter: ArticlesAdapter by lazy {
        ArticlesAdapter { index ->
            viewModel.processUIEvent(UIEvent.OnArticleClicked(index))
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.viewState.observe(viewLifecycleOwner, ::render)

        with(binding) {
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

            ivSearchBotton.setOnClickListener {

//                viewModel.processUIEvent(UIEvent.OnSearchEdit(etTitleSearch.text.toString()))
                viewModel.processUIEvent(UIEvent.OnSearchButtonClicked(etTitleSearch.text.toString()))
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            findNavController().navigate(R.id.bookmarksFragment)
        }

        binding.etTitleSearch.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(
                text: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(text: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(text: Editable?) {
                viewModel.processUIEvent(UIEvent.OnSearchEdit(text.toString()))
            }

        })

    }

    private fun render(viewState: ViewState) {
        when (viewState.state) {
            State.Load -> {
            }
            State.Content -> {
//                with(binding) {
////                    etTitleSearch.isVisible = viewState.isSearchEnabled
////                    if (!etTitleSearch.isVisible) etTitleSearch.setText("")
//                }

                adapter.setData(viewState.articlesShown)
            }
            State.Error -> {
            }
            State.DetailLoad -> {
            }
        }
    }

}