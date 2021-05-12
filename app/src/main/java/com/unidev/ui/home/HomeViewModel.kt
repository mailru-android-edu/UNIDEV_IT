package com.unidev.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.unidev.R

class HomeViewModel : ViewModel() {

    private val _age = MutableLiveData<Int>()
    val age: LiveData<Int>
        get() = _age

    private val _city = MutableLiveData<String>()
    val city: LiveData<String>
        get() = _city

    private val _country = MutableLiveData<String>()
    val country: LiveData<String>
        get() = _country

    private val _guide = MutableLiveData<String>()
    val guide: LiveData<String>
        get() = _guide

    private val _height = MutableLiveData<Int>()
    val height: LiveData<Int>
        get() = _height

    private val _index = MutableLiveData<Double>()
    val index: LiveData<Double>
        get() = _index

    private val _name = MutableLiveData<String>()
    val name: LiveData<String>
        get() = _name

    private val _news: MutableList<NewsItem> = generateList().toMutableList()
    val news: List<NewsItem>
        get() = _news

    private val _subscription = MutableLiveData<String>()
    val subscription: LiveData<String>
        get() = _subscription

    private val _weight = MutableLiveData<Int>()
    val weight: LiveData<Int>
        get() = _weight

    init {
        _age.value = 20
        _city.value = "Москва"
        _country.value = "Россия"
        _guide.value = "Похудение"
        _height.value = 177
        _index.value = 0.0
        _name.value = "Иван Иванов"
        _subscription.value = "Silver"
        _weight.value = 70
    }

    fun setName(firstName: String, secondName: String) {
        _name.value = "$firstName $secondName"
    }
}

fun generateList(): List<NewsItem> {
    return listOf(
        NewsItem("Какой-то заголовок", "27 Янв 2020 19:10", "Какой-то текст", R.mipmap.ic_launcher),
        NewsItem("Какой-то заголовок", "27 Янв 2020 19:10", "Какой-то текст", R.mipmap.ic_launcher),
        NewsItem("Какой-то заголовок", "27 Янв 2020 19:10", "Какой-то текст", R.mipmap.ic_launcher),
        NewsItem("Какой-то заголовок", "27 Янв 2020 19:10", "Какой-то текст", R.mipmap.ic_launcher)
    )
}
