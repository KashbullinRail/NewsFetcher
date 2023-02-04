package com.example.newsfetcher.feature.favourite_news_setting.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newsfetcher.R
import com.example.newsfetcher.databinding.FragmentFavouriteNewsSettingScreenBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class FavouriteNewsSettingScreenFragment :
    Fragment(R.layout.fragment_favourite_news_setting_screen) {

    private val binding by viewBinding(FragmentFavouriteNewsSettingScreenBinding::bind)
    private val viewModel: FavouriteNewsSettingScreenViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.viewState.observe(viewLifecycleOwner, ::render)


    }

    //update UI
    private fun render(viewState: ViewState){

    }


}