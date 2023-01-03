package com.example.newsfetcher.feature.webview_screen.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newsfetcher.R
import com.example.newsfetcher.databinding.FragmentWebviewScreenBinding
import com.example.newsfetcher.feature.main_screen.presentation.PUT_TO_WEBVIEW_FRAGMENT
import com.google.android.material.snackbar.Snackbar


class WebViewScreenFragment : Fragment(R.layout.fragment_webview_screen) {

    private val binding by viewBinding(FragmentWebviewScreenBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val webViewLink = arguments?.getString(PUT_TO_WEBVIEW_FRAGMENT).toString()

        if (webViewLink.startsWith("http")) {
            webViewStart(webViewLink)
            Snackbar.make(view, requireActivity().getString(R.string.loadSite), Snackbar.LENGTH_LONG)
                .show()
        } else {
            Snackbar.make(view, requireActivity().getString(R.string.failUrl), Snackbar.LENGTH_LONG)
                .show()
        }

        with(binding) {
            fabWebViewGoBack.setOnClickListener {
                wvWeb.goBack()
            }

            fabWebViewGoDetail.setOnClickListener {
                findNavController().navigate(R.id.mainScreenFragment)
            }
        }

    }

    @SuppressLint("SetJavaScriptEnabled")
    fun webViewStart(url: String) {

        with(binding) {
            wvWeb.webViewClient = WebViewClient()

            wvWeb.apply {
                loadUrl(url)
                settings.javaScriptEnabled = true
                settings.loadWithOverviewMode = true
            }
        }

    }

}