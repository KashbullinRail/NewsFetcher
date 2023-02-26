package com.example.newsfetcher.feature.news_source_screen.presentation

import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newsfetcher.R
import com.example.newsfetcher.databinding.FragmentNewsSourceScreenBinding
import com.example.newsfetcher.feature.main_screen.presentation.PUT_TO_WEBVIEW_FRAGMENT
import com.example.newsfetcher.feature.source_setting_screen.presentation.SourceSettingScreenFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val SHOW_SOURCE_SETTING = "SHOW_SOURCE_SETTING"


class NewsSourceScreenFragment : Fragment(R.layout.fragment_news_source_screen) {

    private val binding by viewBinding(FragmentNewsSourceScreenBinding::bind)
    private val viewModel: NewsSourceScreenViewModel by viewModel()
    private val adapter: NewsSourceAdapter by lazy {
        NewsSourceAdapter {index, type ->
            viewModel.processUIEvent(UIEvent.OnSourcesClicked(index, type))
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.viewState.observe(viewLifecycleOwner, ::render)

        with(binding) {
            rvNewsSourceScreen.adapter = adapter

            bnvBarNewsSource.setOnItemSelectedListener {
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
                        findNavController().navigate(R.id.starNewsSourcesScreenFragment)
                    }
                    else -> {}
                }
                true
            }

            fabOpenNewsSourceTypeSelect.setOnClickListener {
                val showSourceNews = SourceSettingScreenFragment()
                showSourceNews.show(requireActivity().supportFragmentManager, SHOW_SOURCE_SETTING)
            }

        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            findNavController().navigate(R.id.searchScreenFragment)
        }

    }


    private fun render(viewState: ViewState){

        when (viewState.state) {
            State.Load -> {
                binding.pbNewsSource.isVisible = true
            }
            State.Content -> {
                binding.pbNewsSource.isVisible = false
                adapter.setData(viewState.sourceListShown)
            }
            State.Error -> {
            }
            State.LoadWebView -> {
                binding.pbNewsSource.isVisible = false
                val webViewLink = viewState.sourceDetail.url
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