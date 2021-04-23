package com.unidev.presentation.fragments.trainings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TrainingsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "In this is Fragment there will be training programs" +
            "    In nearest future" +
            "    Some news will be here"
    }
    val text: LiveData<String> = _text
}
