package com.example.newsfetcher.feature.source_bookmarks_screen.presentation

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newsfetcher.R
import com.example.newsfetcher.base.isOnline
import com.example.newsfetcher.databinding.FragmentSourcesBookmarksScreenBinding
import com.example.newsfetcher.feature.main_screen.presentation.PUT_TO_WEBVIEW_FRAGMENT
import com.google.android.material.snackbar.Snackbar
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

        viewModel.viewState.observe(viewLifecycleOwner, ::render)

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
                    R.id.itemSource -> {
                        findNavController().navigate(R.id.newsSourceScreenFragment)
                    }
                    else -> {}
                }
                true
            }
            bnvSourceBarBookmarks.selectedItemId = R.id.itemLikeSources
        }

        if (!isOnline(requireContext())) {
            Snackbar.make(
                view, requireActivity().getString(R.string.offInternet), Snackbar.LENGTH_LONG
            ).show()
        }

    }

    private fun render(viewState: ViewState) {
        when (viewState.state) {
            State.Load -> {
                binding.pbSourceBookmarksScreen.isVisible = true
            }
            State.Content -> {
                binding.pbSourceBookmarksScreen.isVisible = false
                adapter.setData(viewState.bookmarksSource)
            }
            State.Error -> {
            }
            State.LoadWebView -> {
                binding.pbSourceBookmarksScreen.isVisible = false
                val webViewLink = viewState.sourceInfo.url
                if (!webViewLink.isBlank()) {
                    //TODO redirect data transfer to safeArgs
                    val bundle = bundleOf(PUT_TO_WEBVIEW_FRAGMENT to webViewLink)
                    findNavController().saveState()
                    findNavController().navigate(R.id.webViewFragment, bundle)
                }
            }
        }
    }

}