package com.example.newsfetcher.feature.detailscreen.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import com.example.newsfetcher.R
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton


class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val tvHello: TextView by lazy { requireActivity().findViewById(R.id.tVHello) }
    private val progressBar:
            ProgressBar by lazy { requireActivity().findViewById(R.id.progressBar) }
    private val collapsingToolbar:
            CollapsingToolbarLayout by lazy { requireActivity().findViewById(R.id.collapsingToolbar) }
    private val weatherAppBar:
            AppBarLayout by lazy { requireActivity().findViewById(R.id.weatherAppBar) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

}