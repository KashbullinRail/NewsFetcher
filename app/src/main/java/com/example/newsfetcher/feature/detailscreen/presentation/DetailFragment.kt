package com.example.newsfetcher.feature.detailscreen.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.newsfetcher.R
import com.example.newsfetcher.feature.bookmarks.presentation.BookmarksScreenViewModel
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

    private val viewModel: BookmarksScreenViewModel by viewModel()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val detailArticle = arguments?.getSerializable("data")
        Log.d("TAGG12", "Articles book ${detailArticle}")
        Log.d("TAGG12", "Articles book ${viewModel.liviDataDetailImmutable.value}")

//        viewModel.viewState.observe(viewLifecycleOwner, ::render)

//        viewModel.liveDataDetail.observe(viewLifecycleOwner, Observer {
//            tvHello.text = it.title
//            Log.d("TAGG7", "Articles book ${it.title}")
//        })
//
//        tvHello.text = viewModel.liveDataDetail.value?.title.toString()

    }

    private fun render(viewState: ViewState) {
//        when (viewState.state) {
//            State.Load -> {
//                Log.d("TAGG2", "Articles book ${viewState.articleDetail}")
//                tvHello.text = viewState.articleDetail.title
//            }
//            State.Content -> {
//                tvHello.text = viewState.articleDetail.title
//                Log.d("TAGG3", "Articles book ${viewState.articleDetail}")
//            }
//            State.Error -> {
//                tvHello.text = viewState.articleDetail.title
//                Log.d("TAGG5", "Articles book ${viewState.articleDetail}")
//            }
//            State.LoadDetail -> {
//                tvHello.text = viewState.articleDetail.title
//                Log.d("TAGG4", "Articles book ${viewState.articleDetail}")
//            }
//        }

    }

}