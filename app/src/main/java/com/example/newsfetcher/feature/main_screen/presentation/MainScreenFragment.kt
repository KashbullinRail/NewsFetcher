package com.example.newsfetcher.feature.main_screen.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.addCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newsfetcher.R
import com.example.newsfetcher.databinding.FragmentMainScreenBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainScreenFragment : Fragment(R.layout.fragment_main_screen) {

    private val binding by viewBinding(FragmentMainScreenBinding::bind)

    private val viewModel: MainScreenViewModel by viewModel()

    private val adapter: MainArticleAdapter by lazy {
        MainArticleAdapter { index, type ->
            viewModel.processUIEvent(UIEvent.OnArticleClicked(index, type))
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.viewState.observe(viewLifecycleOwner, ::render)

        with(binding) {

            rvArticlesMain.adapter = adapter

            bnvBarMain.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.itemBookmarks -> {
                        findNavController().navigate(R.id.bookmarksFragment)
                    }
                    R.id.itemSearch -> {
                        findNavController().navigate(R.id.searchScreenFragment)
                    }
                    else -> {}
                }
                true
            }
            bnvBarMain.selectedItemId = R.id.itemMain
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
                adapter.setData(viewState.articlesShown)
            }
            State.Error -> {
            }
            State.DetailLoad -> {
                val articleDetail = viewState.articleDetail
                Log.d("TAGG", "Detail MainScreenFragment = ${viewState.articleDetail}")
                //TODO redirect data transfer to safeArgs
                val bundle = bundleOf(MAIN_PUT_TO_DETAIL to articleDetail)
                findNavController().navigate(R.id.detailFragment, bundle)
            }
        }

    }


}