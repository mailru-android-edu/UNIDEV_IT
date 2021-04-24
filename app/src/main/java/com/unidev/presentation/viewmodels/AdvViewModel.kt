package com.unidev.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AdvViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Fragment just for ADVICES" +
                "    In nearest future" +
                "    Some news will be here"
    }
    val text: LiveData<String> = _text
}
