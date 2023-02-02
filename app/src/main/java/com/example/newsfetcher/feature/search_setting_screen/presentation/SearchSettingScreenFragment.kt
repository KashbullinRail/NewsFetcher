package com.example.newsfetcher.feature.search_setting_screen.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.graphics.alpha
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentResultListener
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newsfetcher.R
import com.example.newsfetcher.databinding.FragmentSearchSettingScreenBinding
import com.example.newsfetcher.feature.search_setting_screen.presentation.date_set_screen.DateFromSetFragment
import com.example.newsfetcher.feature.search_setting_screen.presentation.date_set_screen.DateToSetFragment
import com.example.newsfetcher.feature.search_setting_screen.presentation.date_set_screen.REQUEST_DATE_FROM
import com.example.newsfetcher.feature.search_setting_screen.presentation.date_set_screen.REQUEST_DATE_TO
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*


class SearchSettingScreenFragment : DialogFragment(R.layout.fragment_search_setting_screen),
    FragmentResultListener {

    private val binding by viewBinding(FragmentSearchSettingScreenBinding::bind)

    private val viewModel: SearchSettingScreenViewModel by viewModel()
    private lateinit var dateSet: Date

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.viewState.observe(viewLifecycleOwner, ::render)

        dateSet = Date()

        with(binding) {

            tvDataFrom.setOnClickListener {
                openDatePickerFrom()
            }
            tvDataTo.setOnClickListener {
                openDatePickerTo()
            }
            tvTitleSearchIn.setOnClickListener {
                viewModel.processUIEvent(UIEvent.OnTitleSearchInClicked)
            }
            tvDescriptionSearchIn.setOnClickListener {
                viewModel.processUIEvent(UIEvent.OnDescriptionSearchInClicked)
            }
            tvAllSearchIn.setOnClickListener {
                viewModel.processUIEvent(UIEvent.OnAllSearchInClicked)
            }
            tvRelevancy.setOnClickListener {
                viewModel.processUIEvent(UIEvent.OnRelevancyClicked)
            }
            tvPublishedAt.setOnClickListener {
                viewModel.processUIEvent(UIEvent.OnPublishedAtClicked)
            }
            tvPopularity.setOnClickListener {
                viewModel.processUIEvent(UIEvent.OnPopularityClicked)
            }

            btnSaveSearchSetting.setOnClickListener {
                viewModel.processUIEvent(UIEvent.OnSetSearchSettingClicked)
                dialog?.dismiss()
            }

        }

    }

    //update UI
    private fun render(viewState: ViewState) {
        when (viewState.state) {
            State.Load -> {
                //currently not processed, for the future expanded
            }
            State.ContentSearchIn -> {
                with(binding) {
                    if (viewState.titleSearchIn) {
                        tvTitleSearchIn.setBackgroundColor(R.color.colorPrimary.toInt())
                        tvDescriptionSearchIn.setBackgroundColor(R.color.white_100.alpha)
                        tvAllSearchIn.setBackgroundColor(R.color.white_100.alpha)
                    }
                    if (viewState.descriptionSearchIn) {
                        tvDescriptionSearchIn.setBackgroundColor(R.color.colorPrimary.toInt())
                        tvTitleSearchIn.setBackgroundColor(R.color.white_100.alpha)
                        tvAllSearchIn.setBackgroundColor(R.color.white_100.alpha)
                    }
                    if (viewState.allSearchIn) {
                        tvAllSearchIn.setBackgroundColor(R.color.colorPrimary.toInt())
                        tvDescriptionSearchIn.setBackgroundColor(R.color.white_100.alpha)
                        tvTitleSearchIn.setBackgroundColor(R.color.white_100.alpha)
                    }
                }
            }
            State.ContentSortBy -> {
                with(binding) {
                    if (viewState.popularity) {
                        tvPopularity.setBackgroundColor(R.color.colorPrimary.toInt())
                        tvRelevancy.setBackgroundColor(R.color.white_100.alpha)
                        tvPublishedAt.setBackgroundColor(R.color.white_100.alpha)
                    }
                    if (viewState.relevancy) {
                        tvPopularity.setBackgroundColor(R.color.white_100.alpha)
                        tvRelevancy.setBackgroundColor(R.color.colorPrimary.toInt())
                        tvPublishedAt.setBackgroundColor(R.color.white_100.alpha)
                    }
                    if (viewState.publishedAt) {
                        tvPopularity.setBackgroundColor(R.color.white_100.alpha)
                        tvRelevancy.setBackgroundColor(R.color.white_100.alpha)
                        tvPublishedAt.setBackgroundColor(R.color.colorPrimary.toInt())
                    }
                }
            }
            State.ContentDateFrom -> {
                binding.tvDataFrom.text = viewState.dataFrom
            }
            State.ContentDateTo -> {
                binding.tvDataTo.text = viewState.dataTo
            }
            State.Error -> {
                //currently not processed, for the future expanded
            }
        }
    }

    //Function to get selected date from date picker
    override fun onFragmentResult(requestCode: String, result: Bundle) {
        when (requestCode) {
            REQUEST_DATE_FROM -> {
                val index = result.toString().indexOf("=")
                val date = result.toString().removeRange(0..index).removeSuffix("}]")
                Log.d("TAGG", "dateSet when 1 = $date")
                viewModel.processUIEvent(UIEvent.OnDataFromClicked(date))
            }
            REQUEST_DATE_TO -> {
                val index = result.toString().indexOf("=")
                val date = result.toString().removeRange(0..index).removeSuffix("}]")
                Log.d("TAGG", "dateSet when 2 = $date")
                viewModel.processUIEvent(UIEvent.OnDataToClicked(date))
            }
        }
    }

    //Date picker function from...
    private fun openDatePickerFrom() {
        childFragmentManager.setFragmentResultListener(
            REQUEST_DATE_FROM, viewLifecycleOwner, this@SearchSettingScreenFragment
        )
        DateFromSetFragment
            .newInstance(dateSet, REQUEST_DATE_FROM.toInt())
            .show(childFragmentManager, REQUEST_DATE_FROM)
    }

    //Date picker function to...
    private fun openDatePickerTo() {
        childFragmentManager.setFragmentResultListener(
            REQUEST_DATE_TO, viewLifecycleOwner, this@SearchSettingScreenFragment
        )
        DateToSetFragment
            .newInstance(dateSet, REQUEST_DATE_TO.toInt())
            .show(childFragmentManager, REQUEST_DATE_TO)
    }

}