package com.unidev.ui.diet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DietViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This Fragment will show how to stop eat shit)))" +
                "    In nearest future" +
                "    Some news will be here"
    }
    val text: LiveData<String> = _text
}
