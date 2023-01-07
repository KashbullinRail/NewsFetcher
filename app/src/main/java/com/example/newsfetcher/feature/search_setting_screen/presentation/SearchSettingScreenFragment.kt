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
import com.example.newsfetcher.feature.data_set_screen.DataSetFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*


const val REQUEST_DATE_FROM = "123"
const val REQUEST_DATE_TO = "321"


class SearchSettingScreenFragment : DialogFragment(R.layout.fragment_search_setting_screen), FragmentResultListener {

    private val binding by viewBinding(FragmentSearchSettingScreenBinding::bind)

    private val viewModel: SearchSettingScreenViewModel by viewModel()
    private lateinit var dateSet: Date

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.viewState.observe(viewLifecycleOwner, ::render)

        dateSet = Date()

        childFragmentManager.setFragmentResultListener(REQUEST_DATE_FROM, viewLifecycleOwner,this)

        binding.tvFromData.setOnClickListener {
            DataSetFragment
                .newInstance(dateSet, REQUEST_DATE_FROM.toInt())
                .show(childFragmentManager, REQUEST_DATE_FROM)
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
                Log.d("TAGG", "dateSet when = $date")
                binding.tvFromData.text = date
            }
            REQUEST_DATE_TO -> {

            }
        }
    }

}