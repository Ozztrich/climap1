package com.example.climap1.data.remote.api

import com.example.climap1.data.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface WeatherAPI {
    @GET("data/2.5/weather?")
    fun getWeather(
        @Query("lat") latitude: String,
        @Query("lon") longitude: String,
        @Query("appid") apiKey: String
    ) : Observable<WeatherResponse>
}