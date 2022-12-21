package com.example.newsfetcher.feature.detailscreen.presentation

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.newsfetcher.R
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.math.abs


class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val tvTitleDetail: TextView by lazy { requireActivity().findViewById(R.id.tvTitleDetail) }
    private val tvDescription: TextView by lazy { requireActivity().findViewById(R.id.tvDescription) }
    private val progressBar:
            ProgressBar by lazy { requireActivity().findViewById(R.id.progressBar) }
    private val collapsingToolbar:
            CollapsingToolbarLayout by lazy { requireActivity().findViewById(R.id.collapsingToolbar) }
    private val newsDetailAppBar:
            AppBarLayout by lazy { requireActivity().findViewById(R.id.newsDetailAppBar) }
    private val ivNewsDetail: ImageView by lazy { requireActivity().findViewById(R.id.ivNewsDetail) }
    private val fabDeleteDetailItem: FloatingActionButton by lazy {
        requireActivity().findViewById(R.id.fabDeleteDetailItem)
    }

    private val viewModel: DetailScreenViewModel by viewModel()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.viewState.observe(viewLifecycleOwner, ::render)

        newsDetailAppBar.addOnOffsetChangedListener(
            AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
                val percent = (abs(appBarLayout.totalScrollRange + verticalOffset)
                    .toFloat() / appBarLayout.totalScrollRange)
                tvDescription.alpha = percent
                tvTitleDetail.alpha = percent
            })

        fabDeleteDetailItem.setOnClickListener {
            viewModel.processUIEvent(UIEvent.OnDeleteClicked)
        }

    }

    private fun render(viewState: ViewState) {

        when (viewState.state) {
            State.Load -> {
                progressBar.isVisible = true
            }
            State.Content -> {
                progressBar.isVisible = false
                tvTitleDetail.text = viewState.articleDetail.title
                collapsingToolbar.title = viewState.articleDetail.title
                tvDescription.text = viewState.articleDetail.description
                Glide
                    .with(this@DetailFragment)
                    .load(viewState.articleDetail.urlToImage)
                    .placeholder(R.drawable.ic_baseline_image_24)
                    .error(R.drawable.ic_baseline_image_not_supported_24)
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                    .centerCrop()
                    .into(ivNewsDetail)
            }
            State.Error -> {
            }
        }

    }

}