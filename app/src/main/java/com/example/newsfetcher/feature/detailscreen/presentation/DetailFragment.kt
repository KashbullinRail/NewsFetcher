package com.example.newsfetcher.feature.detailscreen.presentation

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.newsfetcher.R
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.math.abs


class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val tvTitleDetail: TextView by lazy { requireActivity().findViewById(R.id.tvTitleDetail) }
    private val tvDescription: TextView by lazy { requireActivity().findViewById(R.id.tvDescriptionDetail) }
    private val tvNameDetail: TextView by lazy { requireActivity().findViewById(R.id.tvNameDetail) }
    private val tvLinkToSourceDetail: TextView by lazy { requireActivity().findViewById(R.id.tvLinkToSourceDetail) }
    private val tvAuthorDetail: TextView by lazy { requireActivity().findViewById(R.id.tvAuthorDetail) }
    private val tvDataDetail: TextView by lazy { requireActivity().findViewById(R.id.tvDataDetail) }
    private val ivNewsDetail: ImageView by lazy { requireActivity().findViewById(R.id.ivNewsDetail) }


    private val viewModel: DetailScreenViewModel by viewModel()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        lifecycleScope.launchWhenStarted {
//            viewModel.viewState.collect { state -> state?.let { this@DetailFragment::render } }
//        }

        viewModel.viewState.observe(viewLifecycleOwner, ::render)

//        newsDetailAppBar.addOnOffsetChangedListener(
//            AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
//                val percent = (abs(appBarLayout.totalScrollRange + verticalOffset)
//                    .toFloat() / appBarLayout.totalScrollRange)
//                tvDescription.alpha = percent
//                tvTitleDetail.alpha = percent
//            })

    }

    private fun render(viewState: ViewState) {

        when (viewState.state) {
            State.Load -> {

            }
            State.Content -> {
                tvTitleDetail.text = viewState.articleDetail.title
                tvDescription.text = viewState.articleDetail.description
                tvAuthorDetail.text = viewState.articleDetail.author
                tvNameDetail.text = viewState.articleDetail.name
                tvDataDetail.text = viewState.articleDetail.publishedAt
                tvLinkToSourceDetail.text = viewState.articleDetail.url
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