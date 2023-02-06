package com.example.newsfetcher.feature.favourite_news_setting_screen.presentation

import android.os.Bundle
import android.view.View
import androidx.core.graphics.alpha
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newsfetcher.R
import com.example.newsfetcher.databinding.FragmentFavouriteNewsSettingScreenBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class FavouriteNewsSettingScreenFragment :
    DialogFragment(R.layout.fragment_favourite_news_setting_screen) {

    private val binding by viewBinding(FragmentFavouriteNewsSettingScreenBinding::bind)
    private val viewModel: FavouriteNewsSettingScreenViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.viewState.observe(viewLifecycleOwner, ::render)

        with(binding) {
            tvBusinessFavourite.setOnClickListener {
                viewModel.processUIEvent(UIEvent.OnBusinessClicked)
            }
            tvEntertainmentFavourite.setOnClickListener {
                viewModel.processUIEvent(UIEvent.OnEntertainmentClicked)
            }
            tvGeneralFavourite.setOnClickListener {
                viewModel.processUIEvent(UIEvent.OnGeneralClicked)
            }
            tvHealthFavourite.setOnClickListener {
                viewModel.processUIEvent(UIEvent.OnHealthClicked)
            }
            tvScienceFavourite.setOnClickListener {
                viewModel.processUIEvent(UIEvent.OnScienceClicked)
            }
            tvSportsFavourite.setOnClickListener {
                viewModel.processUIEvent(UIEvent.OnSportsClicked)
            }
            tvTechnologyFavourite.setOnClickListener {
                viewModel.processUIEvent(UIEvent.OnTechnologyClicked)
            }
            btnCancelFavouriteSetting.setOnClickListener {
                dialog?.dismiss()
            }
            btnSaveFavouriteSetting.setOnClickListener {
                viewModel.processUIEvent(UIEvent.OnSetFavouriteNewsSettingClicked)
                findNavController().navigate(R.id.mainScreenFragment)
                dialog?.dismiss()
            }
        }

    }

    //update UI
    private fun render(viewState: ViewState) {

        when (viewState.state) {
            State.Load -> {
                binding.pbFavouriteNewsSettingMenu.isVisible = true
            }
            State.Content -> {
                with(binding) {
                    pbFavouriteNewsSettingMenu.isVisible = false
                    if (viewState.favouriteNews.equals(FavouriteNews.business.str)) {
                        tvBusinessFavourite.setBackgroundColor(R.color.colorPrimary.toInt())
                    } else {
                        tvBusinessFavourite.setBackgroundColor(R.color.white_100.alpha)
                    }
                    if (viewState.favouriteNews.equals(FavouriteNews.entertaiment.str)) {
                        tvEntertainmentFavourite.setBackgroundColor(R.color.colorPrimary.toInt())
                    } else {
                        tvEntertainmentFavourite.setBackgroundColor(R.color.white_100.alpha)
                    }
                    if (viewState.favouriteNews.equals(FavouriteNews.general.str)) {
                        tvGeneralFavourite.setBackgroundColor(R.color.colorPrimary.toInt())
                    } else {
                        tvGeneralFavourite.setBackgroundColor(R.color.white_100.alpha)
                    }
                    if (viewState.favouriteNews.equals(FavouriteNews.health.str)) {
                        tvHealthFavourite.setBackgroundColor(R.color.colorPrimary.toInt())
                    } else {
                        tvHealthFavourite.setBackgroundColor(R.color.white_100.alpha)
                    }
                    if (viewState.favouriteNews.equals(FavouriteNews.science.str)) {
                        tvScienceFavourite.setBackgroundColor(R.color.colorPrimary.toInt())
                    } else {
                        tvScienceFavourite.setBackgroundColor(R.color.white_100.alpha)
                    }
                    if (viewState.favouriteNews.equals(FavouriteNews.sports.str)) {
                        tvSportsFavourite.setBackgroundColor(R.color.colorPrimary.toInt())
                    } else {
                        tvSportsFavourite.setBackgroundColor(R.color.white_100.alpha)
                    }
                    if (viewState.favouriteNews.equals(FavouriteNews.technology.str)) {
                        tvTechnologyFavourite.setBackgroundColor(R.color.colorPrimary.toInt())
                    } else {
                        tvTechnologyFavourite.setBackgroundColor(R.color.white_100.alpha)
                    }
                }
            }
            State.Error -> {

            }
        }

    }

}