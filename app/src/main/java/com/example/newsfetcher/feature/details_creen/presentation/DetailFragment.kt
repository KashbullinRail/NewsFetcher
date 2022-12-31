package com.example.newsfetcher.feature.details_creen.presentation

import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.newsfetcher.R
import com.example.newsfetcher.databinding.FragmentDetailBinding
import com.example.newsfetcher.feature.main_screen.domian.ArticleModel
import com.example.newsfetcher.feature.main_screen.presentation.MAIN_PUT_TO_DETAIL
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val binding by viewBinding(FragmentDetailBinding::bind)

    private val viewModel: DetailScreenViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            binding.fabDetailGoToMain.setOnClickListener {
            findNavController().navigate(R.id.mainScreenFragment)
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            findNavController().navigate(R.id.mainScreenFragment)
        }

        viewModel.viewState.observe(viewLifecycleOwner, ::render)

//        newsDetailAppBar.addOnOffsetChangedListener(
//            AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
//                val percent = (abs(appBarLayout.totalScrollRange + verticalOffset)
//                    .toFloat() / appBarLayout.totalScrollRange)
//                tvDescription.alpha = percent
//                tvTitleDetail.alpha = percent
//            })


       val detailArticle =  arguments?.getSerializable(MAIN_PUT_TO_DETAIL)
        viewModel.processUIEvent(UIEvent.OnDetailArticleGet(detailArticle as ArticleModel))

    }

    private fun render(viewState: ViewState) {

        when (viewState.state) {
            State.Load -> {
            }
            State.Content -> {
                with(binding) {
                    tvTitleDetail.text = viewState.articleDetail.title
                    tvDescriptionDetail.text = viewState.articleDetail.description
                    tvAuthorDetail.text = viewState.articleDetail.author
                    tvNameDetail.text = viewState.articleDetail.name
                    tvDataDetail.text = viewState.articleDetail.publishedAt
                    tvLinkToSourceDetail.text = viewState.articleDetail.url
                    Glide
                        .with(this@DetailFragment)
                        .load(viewState.articleDetail.urlToImage)
                        .placeholder(R.drawable.ic_image)
                        .error(R.drawable.ic_image_not_supported)
                        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                        .centerCrop()
                        .into(ivNewsDetail)
                }
            }
            State.Error -> {
            }
        }

    }

}