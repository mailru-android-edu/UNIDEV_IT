package com.unidev.presentation.fragments.motivation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MotivationViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "In this Fragment there will be some things for your motivation" +
            "    In nearest future" +
            "    Some news will be here"
    }
    val text: LiveData<String> = _text
}
