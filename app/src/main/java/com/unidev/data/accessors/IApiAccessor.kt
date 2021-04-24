package com.unidev.data.accessors

import com.unidev.data.objects.api.ApiListResult
import com.unidev.data.objects.api.Place
import com.unidev.data.objects.api.WeatherData
import retrofit2.http.GET
import retrofit2.http.Query

interface IApiAccessor {
    @GET("find")
    suspend fun find(@Query("q") query: String): ApiListResult<Place>

    @GET("weather")
    suspend fun weather(@Query("id") id: Long): WeatherData
}