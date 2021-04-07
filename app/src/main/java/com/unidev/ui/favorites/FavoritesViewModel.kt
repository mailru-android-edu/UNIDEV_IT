package com.unidev.ui.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FavoritesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Fragment for your favourite trainings, diets and news" +
                "    In nearest future" +
                "    Some news will be here"
    }
    val text: LiveData<String> = _text
}