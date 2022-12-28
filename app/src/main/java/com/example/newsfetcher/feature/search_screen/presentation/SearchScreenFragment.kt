package com.example.newsfetcher.feature.search_screen.presentation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.addCallback
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.newsfetcher.R
import com.example.newsfetcher.feature.main_screen.presentation.ArticlesAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel


class SearchScreenFragment : Fragment(R.layout.fragment_news_search) {

    private val viewModel: SearchScreenViewModel by viewModel()

    private val bottomNavigationMenu: BottomNavigationView by lazy { requireActivity().findViewById(R.id.bnvBarSearch) }
    private val recyclerView: RecyclerView by lazy { requireActivity().findViewById(R.id.rvArticlesSearch) }
    private val ivSearch: ImageView by lazy { requireActivity().findViewById(R.id.ivSearchBotton) }
    private val etTitleSearch: EditText by lazy { requireActivity().findViewById(R.id.etTitleSearch) }
    private val adapter: ArticlesAdapter by lazy {
        ArticlesAdapter { index ->
            viewModel.processUIEvent(UIEvent.OnArticleClicked(index))
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            findNavController().navigate(R.id.bookmarksFragment)
        }

        bottomNavigationMenu.setOnItemSelectedListener {
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

        bottomNavigationMenu.selectedItemId = R.id.itemSearch

        viewModel.viewState.observe(viewLifecycleOwner, ::render)

        recyclerView.adapter = adapter

        ivSearch.setOnClickListener {
            viewModel.processUIEvent(UIEvent.OnSearchButtonCliked)
        }

        etTitleSearch.addTextChangedListener(object : TextWatcher {

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
                etTitleSearch.isVisible = viewState.isSearchEnabled
                if (!etTitleSearch.isVisible) etTitleSearch.setText("")
                adapter.setData(viewState.articlesShown)
            }
            State.Error -> {
            }
            State.DetailLoad -> {
            }
        }

    }

}