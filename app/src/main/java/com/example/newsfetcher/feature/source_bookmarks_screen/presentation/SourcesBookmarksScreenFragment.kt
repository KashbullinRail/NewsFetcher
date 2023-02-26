package com.example.newsfetcher.feature.source_bookmarks_screen.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newsfetcher.R
import com.example.newsfetcher.databinding.FragmentSourcesBookmarksScreenBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class SourcesBookmarksScreenFragment : Fragment(R.layout.fragment_sources_bookmarks_screen) {

    private val binding by viewBinding(FragmentSourcesBookmarksScreenBinding::bind)
    private val viewModel: SourceBookmarksScreenViewModel by viewModel()
    private val adapter: SourceBookmarksAdapter by lazy {
        SourceBookmarksAdapter { index, type ->
            viewModel.processUIEvent(UIEvent.OnSourceClicked(index, type))
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            rvSourceBookmarkArticles.adapter = adapter

            bnvSourceBarBookmarks.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.itemBookmarks -> {
                        findNavController().navigate(R.id.bookmarksScreenFragment)
                    }
                   R.id.itemSearch -> {
                        findNavController().navigate(R.id.searchScreenFragment)
                    }
                    R.id.itemMain -> {
                        findNavController().navigate(R.id.mainScreenFragment)
                    }
                    R.id.itemLikeSources -> {
                        findNavController().navigate(R.id.newsSourceScreenFragment)
                    }
                    else -> {}
                }
                true
            }

        }


    }


}