package com.example.newsfetcher.feature.favourite_news_setting_screen.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.DialogFragment
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
                dialog?.dismiss()
            }
        }

    }

    //update UI
    private fun render(viewState: ViewState){

    }


}