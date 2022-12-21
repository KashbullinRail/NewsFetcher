package com.example.newsfetcher.feature.detailscreen.presentation

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.newsfetcher.R
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val tvHello: TextView by lazy { requireActivity().findViewById(R.id.tVHello) }
    private val progressBar:
            ProgressBar by lazy { requireActivity().findViewById(R.id.progressBar) }
    private val collapsingToolbar:
            CollapsingToolbarLayout by lazy { requireActivity().findViewById(R.id.collapsingToolbar) }
    private val weatherAppBar:
            AppBarLayout by lazy { requireActivity().findViewById(R.id.weatherAppBar) }

    private val viewModel: DetailScreenViewModel by viewModel()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }

    private fun render(viewState: ViewState) {


    }

}