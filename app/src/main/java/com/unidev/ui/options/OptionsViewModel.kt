package com.unidev.ui.options

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OptionsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Fragment just for some parameters of your body" +
                "    In nearest future" +
                "    Some news will be here"
    }
    val text: LiveData<String> = _text
}
