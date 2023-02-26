package com.example.newsfetcher.feature.star_news_sources_screen.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newsfetcher.R
import com.example.newsfetcher.databinding.FragmentStarNewsSourcesScreenBinding


class StarNewsSourcesScreenFragment : Fragment(R.layout.fragment_star_news_sources_screen) {

    private val binding by viewBinding(FragmentStarNewsSourcesScreenBinding::bind)
//    private val viewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        with(binding) {
//            rvNewsSourceScreen.adapter = adapter
//
//            bnvBarNewsSource.setOnItemSelectedListener {
//                when (it.itemId) {
//                    com.example.newsfetcher.R.id.itemBookmarks -> {
//                        findNavController().navigate(com.example.newsfetcher.R.id.bookmarksScreenFragment)
//                    }
//                    com.example.newsfetcher.R.id.itemSearch -> {
//                        findNavController().navigate(com.example.newsfetcher.R.id.searchScreenFragment)
//                    }
//                    com.example.newsfetcher.R.id.itemMain -> {
//                        findNavController().navigate(com.example.newsfetcher.R.id.mainScreenFragment)
//                    }
//                    com.example.newsfetcher.R.id.itemLikeSources -> {
//                        findNavController().navigate(com.example.newsfetcher.R.id.starNewsSourcesScreenFragment)
//                    }
//                    else -> {}
//                }
//                true
//            }
//
//        }


    }


}