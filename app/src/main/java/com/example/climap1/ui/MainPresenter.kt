package com.example.climap1.ui

import android.content.Context
import com.example.climap1.data.manager.DataManager
import com.example.climap1.data.model.WeatherResponse
import com.example.climap1.util.SharedPreferencesConnector
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


class MainPresenter(
    private val view: MainContract.View,
    private val context: Context
) : MainContract.Presenter {
    private val connector = SharedPreferencesConnector.getInstance(context)
    private val dataManager = DataManager(context)

    override fun getWeather() {
        val latitude = connector.readString("latitude", "32.660996774840875")
        val longitude = connector.readString("longitude", "-115.42016776965127")
        val apiKey = connector.readString("apiKey", com.example.climap1.data.remote.constants.API.API_KEY)

        val observable = dataManager.getWeather(latitude, longitude, apiKey)
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Subscriber<WeatherResponse>() {

                override fun onError(e: Throwable?) {
                    e?.printStackTrace()
                }

                override fun onNext(t: WeatherResponse) {
                    val temperatureInKelvin = t.main!!.feels_like
                    val temperatureInCelsius = temperatureInKelvin - 273.15
                    val locationName = t.name?:"unknown location"
                    view.showWeather(temperatureInCelsius.toString())
                    view.showLocation(locationName)
                }

                override fun onCompleted() {
                    // no necesario
                }
            })
    }
}