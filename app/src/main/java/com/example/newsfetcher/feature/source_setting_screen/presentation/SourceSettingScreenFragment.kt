package com.example.newsfetcher.feature.source_setting_screen.presentation

import android.os.Bundle
import android.view.View
import androidx.core.graphics.alpha
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newsfetcher.R
import com.example.newsfetcher.databinding.FragmentSourceSettingScreenBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class SourceSettingScreenFragment : DialogFragment(R.layout.fragment_source_setting_screen) {

    private val binding by viewBinding(FragmentSourceSettingScreenBinding::bind)
    private val viewModel: SourceNewsSettingScreenViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.viewState.observe(viewLifecycleOwner, ::render)

        with(binding) {
            tvBusinessSourceSetting.setOnClickListener {
                viewModel.processUIEvent(UIEvent.OnBusinessClicked)
            }
            tvEntertainmentSourceSetting.setOnClickListener {
                viewModel.processUIEvent(UIEvent.OnEntertainmentClicked)
            }
            tvGeneralSourceSetting.setOnClickListener {
                viewModel.processUIEvent(UIEvent.OnGeneralClicked)
            }
            tvHealthSourceSetting.setOnClickListener {
                viewModel.processUIEvent(UIEvent.OnHealthClicked)
            }
            tvScienceSourceSetting.setOnClickListener {
                viewModel.processUIEvent(UIEvent.OnScienceClicked)
            }
            tvSportsSourceSetting.setOnClickListener {
                viewModel.processUIEvent(UIEvent.OnSportsClicked)
            }
            tvTechnologySourceSetting.setOnClickListener {
                viewModel.processUIEvent(UIEvent.OnTechnologyClicked)
            }
            tvENSourceSetting.setOnClickListener {
                viewModel.processUIEvent(UIEvent.OnEnglishLanguageClicked)
            }
            tvRUSourceSetting.setOnClickListener {
                viewModel.processUIEvent(UIEvent.OnRussiaLanguageClicked)
            }
            btnCancelSourceSetting.setOnClickListener {
                dialog?.dismiss()
            }
            btnSaveSourceSetting.setOnClickListener {
                viewModel.processUIEvent(UIEvent.OnSetFavouriteNewsSettingClicked)
                findNavController().navigate(R.id.newsSourceScreenFragment)
                dialog?.dismiss()
            }
        }

    }

    //update UI
    private fun render(viewState: ViewState) {

        when (viewState.state) {
            State.Load -> {
                binding.pbSourceNewsSettingMenu.isVisible = true
            }
            State.Content -> {
                with(binding) {
                    pbSourceNewsSettingMenu.isVisible = false
                    if (viewState.sourceNews.equals(SourceNews.business.str)) {
                        tvBusinessSourceSetting.setBackgroundColor(R.color.colorPrimary.toInt())
                    } else {
                        tvBusinessSourceSetting.setBackgroundColor(R.color.white_100.alpha)
                    }
                    if (viewState.sourceNews.equals(SourceNews.entertaiment.str)) {
                        tvEntertainmentSourceSetting.setBackgroundColor(R.color.colorPrimary.toInt())
                    } else {
                        tvEntertainmentSourceSetting.setBackgroundColor(R.color.white_100.alpha)
                    }
                    if (viewState.sourceNews.equals(SourceNews.general.str)) {
                        tvGeneralSourceSetting.setBackgroundColor(R.color.colorPrimary.toInt())
                    } else {
                        tvGeneralSourceSetting.setBackgroundColor(R.color.white_100.alpha)
                    }
                    if (viewState.sourceNews.equals(SourceNews.health.str)) {
                        tvHealthSourceSetting.setBackgroundColor(R.color.colorPrimary.toInt())
                    } else {
                        tvHealthSourceSetting.setBackgroundColor(R.color.white_100.alpha)
                    }
                    if (viewState.sourceNews.equals(SourceNews.science.str)) {
                        tvScienceSourceSetting.setBackgroundColor(R.color.colorPrimary.toInt())
                    } else {
                        tvScienceSourceSetting.setBackgroundColor(R.color.white_100.alpha)
                    }
                    if (viewState.sourceNews.equals(SourceNews.sports.str)) {
                        tvSportsSourceSetting.setBackgroundColor(R.color.colorPrimary.toInt())
                    } else {
                        tvSportsSourceSetting.setBackgroundColor(R.color.white_100.alpha)
                    }
                    if (viewState.sourceNews.equals(SourceNews.technology.str)) {
                        tvTechnologySourceSetting.setBackgroundColor(R.color.colorPrimary.toInt())
                    } else {
                        tvTechnologySourceSetting.setBackgroundColor(R.color.white_100.alpha)
                    }
                    if (viewState.languageNews.equals(LanguageNews.russia.str)) {
                        tvRUSourceSetting.setBackgroundColor(R.color.colorPrimary.toInt())
                    } else {
                        tvRUSourceSetting.setBackgroundColor(R.color.white_100.alpha)
                    }
                    if (viewState.languageNews.equals(LanguageNews.english.str)) {
                        tvENSourceSetting.setBackgroundColor(R.color.colorPrimary.toInt())
                    } else {
                        tvENSourceSetting.setBackgroundColor(R.color.white_100.alpha)
                    }
                }
            }
            State.Error -> {

            }
        }

    }

}