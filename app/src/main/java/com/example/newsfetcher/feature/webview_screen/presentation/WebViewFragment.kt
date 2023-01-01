package com.example.newsfetcher.feature.webview_screen.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newsfetcher.R
import com.example.newsfetcher.databinding.FragmentWebviewScreenBinding
import com.example.newsfetcher.feature.main_screen.presentation.PUT_TO_WEBVIEW_FRAGMENT


class WebViewFragment : Fragment(R.layout.fragment_webview_screen) {

    private val binding by viewBinding(FragmentWebviewScreenBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val webViewLink = arguments?.getSerializable(PUT_TO_WEBVIEW_FRAGMENT)



    }

}