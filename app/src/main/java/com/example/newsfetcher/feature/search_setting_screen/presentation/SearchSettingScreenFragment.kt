package com.example.newsfetcher.feature.search_setting_screen.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
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


class SearchSettingScreenFragment : DialogFragment(R.layout.fragment_search_setting_screen), FragmentResultListener {

    private val binding by viewBinding(FragmentSearchSettingScreenBinding::bind)

    private val viewModel: SearchSettingScreenViewModel by viewModel()
    private lateinit var dateSet: Date

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.viewState.observe(viewLifecycleOwner, ::render)

        dateSet = Date()

        binding.tvDataFrom.setOnClickListener {
            childFragmentManager.setFragmentResultListener(REQUEST_DATE_FROM, viewLifecycleOwner,this)
            DateFromSetFragment
                .newInstance(dateSet, REQUEST_DATE_FROM.toInt())
                .show(childFragmentManager, REQUEST_DATE_FROM)
        }

        binding.tvDataTo.setOnClickListener {
            childFragmentManager.setFragmentResultListener(REQUEST_DATE_TO, viewLifecycleOwner, this)
            DateToSetFragment
                .newInstance(dateSet, REQUEST_DATE_TO.toInt())
                .show(childFragmentManager, REQUEST_DATE_TO)
        }

    }

    private fun render(viewState: ViewState) {
        when (viewState.state) {
            State.Load -> {
            }
            State.Content -> {
            }
            State.Error -> {
            }
            State.DataPickerLoad -> {
                findNavController().navigate(R.id.detailFragment)
            }
        }
    }

    override fun onFragmentResult(requestCode: String, result: Bundle) {
        when(requestCode) {
            REQUEST_DATE_FROM -> {
                val index = result.toString().indexOf("=")
                val date = result.toString().removeRange(0..index).removeSuffix("}]")
                Log.d("TAGG", "dateSet when 1 = $date")
                binding.tvDataFrom.text = date
            }
            REQUEST_DATE_TO -> {
                val index = result.toString().indexOf("=")
                val date = result.toString().removeRange(0..index).removeSuffix("}]")
                Log.d("TAGG", "dateSet when 2 = $date")
                binding.tvDataTo.text = date
            }
        }
    }

}