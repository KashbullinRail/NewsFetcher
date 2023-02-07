package com.example.newsfetcher.feature.main_screen.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.addCallback
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newsfetcher.R
import com.example.newsfetcher.base.isOnline
import com.example.newsfetcher.databinding.FragmentMainScreenBinding
import com.example.newsfetcher.feature.favourite_news_setting_screen.presentation.FavouriteNewsSettingScreenFragment
import com.example.newsfetcher.feature.main_screen.di.setUrl
import com.example.newsfetcher.feature.main_screen.presentation.PUT_TO_DETAIL_FRAGMENT
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel


private const val SHOW_FAVOURITE_SETTING = "SHOW_FAVOURITE_SETTING"

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

//        setUrl("1")

        viewModel.viewState.observe(viewLifecycleOwner, ::render)

        with(binding) {
            rvArticlesMain.adapter = adapter

            bnvBarMain.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.itemBookmarks -> {
                        findNavController().navigate(R.id.bookmarksScreenFragment)
                    }
                    R.id.itemSearch -> {
                        findNavController().navigate(R.id.searchScreenFragment)
                    }
                    else -> {}
                }
                true
            }
            bnvBarMain.selectedItemId = R.id.itemMain
            bnvBarMain.selectedItemId = R.id.itemMain

            fabOpenFavouriteSettingScreen.setOnClickListener {
                val showFavouriteNews = FavouriteNewsSettingScreenFragment()
               showFavouriteNews.show(requireActivity().supportFragmentManager, SHOW_FAVOURITE_SETTING)
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            findNavController().navigate(R.id.)
        }

        if (!isOnline(requireContext())){
            Snackbar.make(view, requireActivity().getString(R.string.offInternet), Snackbar.LENGTH_LONG)
                .show()
        }

    }

    private fun render(viewState: ViewState) {

        when (viewState.state) {
            State.Load -> {
                binding.pbMainScreen.isVisible = true
            }
            State.Content -> {
                binding.pbMainScreen.isVisible = false
                adapter.setData(viewState.articlesShown)
            }
            State.Error -> {
            }
            State.DetailLoad -> {
                binding.pbMainScreen.isVisible = false
                val articleDetail = viewState.articleDetail
                Log.d("TAGG", "Detail MainScreenFragment = ${viewState.articleDetail}")
                //TODO redirect data transfer to safeArgs
                val bundle = bundleOf(PUT_TO_DETAIL_FRAGMENT to articleDetail)
                findNavController().navigate(R.id.detailFragment, bundle)
            }
        }

    }


}