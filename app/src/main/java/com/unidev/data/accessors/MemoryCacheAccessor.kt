package com.unidev.data.accessors

import android.os.SystemClock

class MemoryCacheAccessor<T> : ICacheAccessor<T> {
    private val map = mutableMapOf<String, Pair<Long, List<T>>>()

    override fun get(key: String, maxLiveTimeInMillis: Long): List<T>? {
        val pair = map[key] ?: return null

        val deltaTime = SystemClock.elapsedRealtime() - pair.first
        if (deltaTime > maxLiveTimeInMillis) {
            map.remove(key)
            return null
        }

        return pair.second
    }

    override fun put(key: String, list: List<T>?) {
        when (list) {
            null -> map.remove(key)
            else -> map[key] = Pair(SystemClock.elapsedRealtime(), list)
        }
    }
}
