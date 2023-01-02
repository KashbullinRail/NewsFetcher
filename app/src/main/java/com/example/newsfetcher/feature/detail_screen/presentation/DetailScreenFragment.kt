package com.example.newsfetcher.feature.detail_screen.presentation

import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.newsfetcher.R
import com.example.newsfetcher.databinding.FragmentDetailScreenBinding
import com.example.newsfetcher.feature.main_screen.news.data.ArticleModel
import com.example.newsfetcher.feature.main_screen.presentation.PUT_TO_DETAIL_FRAGMENT
import com.example.newsfetcher.feature.main_screen.presentation.PUT_TO_WEBVIEW_FRAGMENT
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailScreenFragment : Fragment(R.layout.fragment_detail_screen) {

    private val binding by viewBinding(FragmentDetailScreenBinding::bind)

    private val viewModel: DetailScreenViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            findNavController().navigate(R.id.mainScreenFragment)
        }

        viewModel.viewState.observe(viewLifecycleOwner, ::render)

        val detailArticle = arguments?.getSerializable(PUT_TO_DETAIL_FRAGMENT)
        viewModel.processUIEvent(UIEvent.OnDetailArticleGet(detailArticle as ArticleModel))

        with(binding) {

            bnvBarDetail.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.itemMain -> {
                        findNavController().navigate(R.id.mainScreenFragment)
                    }
                    R.id.itemBookmarks -> {
                        findNavController().navigate(R.id.bookmarksFragment)
                    }
                    R.id.itemSearch -> {
                        findNavController().navigate(R.id.searchScreenFragment)
                    }
                    else -> {}
                }
                true
            }

            tvLinkToSourceDetail.setOnClickListener {
                viewModel.processUIEvent(UIEvent.OnWebViewLink(detailArticle.url))
            }

        }

        //for the development of the project in the future
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
            State.Load -> {}
            State.Content -> {
                with(binding) {
                    tvTitleDetail.text = viewState.detailArticle.title
                    tvDescriptionDetail.text = viewState.detailArticle.description
                    tvAuthorDetail.text = viewState.detailArticle.author
                    tvNameDetail.text = viewState.detailArticle.name
                    tvDataDetail.text = viewState.detailArticle.publishedAt
                    tvLinkToSourceDetail.text = viewState.detailArticle.url
                    Glide
                        .with(this@DetailScreenFragment)
                        .load(viewState.detailArticle.urlToImage)
                        .placeholder(R.drawable.ic_image)
                        .error(R.drawable.ic_image_not_supported)
                        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                        .centerCrop()
                        .into(ivNewsDetail)
                }
            }
            State.LoadWebView -> {
                val webViewLink = viewState.webViewLink
                if (!webViewLink.isBlank()) {
                    //TODO redirect data transfer to safeArgs
                    val bundle = bundleOf(PUT_TO_WEBVIEW_FRAGMENT to webViewLink)
                    findNavController().navigate(R.id.webViewFragment, bundle)
                }

            }
            State.Error -> {}
        }

    }

}