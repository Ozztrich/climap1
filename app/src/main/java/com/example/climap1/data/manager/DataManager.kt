package com.example.climap1.data.manager

import android.content.Context
import com.example.climap1.data.model.WeatherResponse
import com.example.climap1.data.remote.api.WeatherAPI
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observable

class DataManager(context: Context) {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .build()

    private val weatherAPI: WeatherAPI = retrofit.create(WeatherAPI::class.java)

    fun getWeather(latitude: String, longitude: String, apiKey: String): Observable<WeatherResponse> {
        return weatherAPI.getWeather(latitude, longitude, apiKey)
    }
}