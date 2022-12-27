package com.example.newsfetcher.feature.main_screen.presentation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.addCallback
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.newsfetcher.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainScreenFragment : Fragment(R.layout.fragment_main_screen) {

    private val viewModel: MainScreenViewModel by viewModel()

    private val bottomNavigationMenu: BottomNavigationView by lazy { requireActivity().findViewById(R.id.bnvBar) }
    private val recyclerView: RecyclerView by lazy { requireActivity().findViewById(R.id.rvArticles) }
    private val ivSearch: ImageView by lazy { requireActivity().findViewById(R.id.ivSearch) }
    private val tvTitle: TextView by lazy { requireActivity().findViewById(R.id.tvTitleBookmarks) }
    private val etSearch: EditText by lazy { requireActivity().findViewById(R.id.etSearch) }
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
                else -> {}
            }
            true
        }
        bottomNavigationMenu.selectedItemId = R.id.itemMain

        viewModel.viewState.observe(viewLifecycleOwner, ::render)

        recyclerView.adapter = adapter

        ivSearch.setOnClickListener {
            viewModel.processUIEvent(UIEvent.OnSearchButtonCliked)
        }

        etSearch.addTextChangedListener(object : TextWatcher {

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
                tvTitle.isVisible = !viewState.isSearchEnabled
                etSearch.isVisible = viewState.isSearchEnabled
                if (!etSearch.isVisible) etSearch.setText("")
                adapter.setData(viewState.articlesShown)
            }
            State.Error -> {
            }
            State.DetailLoad -> {
            }
        }

    }

}