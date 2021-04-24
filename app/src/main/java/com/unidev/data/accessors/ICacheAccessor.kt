package com.unidev.data.accessors

import java.util.concurrent.TimeUnit

interface ICacheAccessor<T> {
    fun get(key: String, maxLiveTimeInMillis: Long = TIME_5_MINUTES): List<T>?
    fun put(key: String, list: List<T>?)


    companion object {
        val TIME_5_MINUTES = TimeUnit.MINUTES.toMillis(5)
    }
}