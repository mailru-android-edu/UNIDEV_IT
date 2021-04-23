package com.unidev.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WorkoutViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "In this is Fragment there will be training programs" +
                "    In nearest future" +
                "    Some news will be here"
    }
    val text: LiveData<String> = _text
}