package com.unidev.ui.blog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BlogViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is blog Fragment" +
                "    In nearest future" +
                "    Some news will be here"
    }
    val text: LiveData<String> = _text
}
