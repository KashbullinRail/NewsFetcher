package com.example.newsfetcher.feature.setting_screen.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newsfetcher.R
import com.example.newsfetcher.databinding.FragmentSettingScreenBinding


class SettingScreenFragment : DialogFragment(R.layout.fragment_setting_screen) {

    private val binding by viewBinding(FragmentSettingScreenBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }



}