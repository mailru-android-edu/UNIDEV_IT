package com.unidev.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.unidev.R
import kotlin.math.pow

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
        _name.value = "Иван Иванов"
        _subscription.value = "Silver"
        _weight.value = 70
        _index.value = calcIndex(_height.value!!, _weight.value!!)
    }

    fun setParameters(height: Int, weight: Int) {
        _height.value = height
        _weight.value = weight
        _index.value = calcIndex(_height.value!!, _weight.value!!)
    }
}

fun generateList(): List<NewsItem> {
    return listOf(
        NewsItem("Что-то важное", "27 Янв 2021 19:10", R.drawable.running),
        NewsItem("Что-то о спорте", "28 Янв 2021 13:18", R.drawable.running),
        NewsItem("Ещё что-то о спорте", "01 Фев 2021 22:01", R.drawable.running),
        NewsItem("Самое интересное", "03 Фев 2021 15:32", R.drawable.running)
    )
}

fun calcIndex(height: Int, weight: Int) = weight / (height.toDouble() / 100).pow(2)
