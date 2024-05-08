package com.example.climap1.ui

interface MainContract {
    interface View{
        fun showWeather(climate: String)
        fun showLocation(location: String)
    }

    interface Presenter{
        fun getWeather()
    }



}