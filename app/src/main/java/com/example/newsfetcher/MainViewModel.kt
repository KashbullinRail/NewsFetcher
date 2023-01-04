package com.example.newsfetcher

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {

    private val _isLoding = MutableStateFlow(true)
    val isLoading = _isLoding.asStateFlow()

    init {
        viewModelScope.launch {
            delay(300)
            _isLoding.value = false
        }
    }

}