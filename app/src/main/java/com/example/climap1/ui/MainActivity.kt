package com.example.climap1.ui

import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.climap1.R

class MainActivity : AppCompatActivity(), MainContract.View
{
    private var presenter: MainPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this,this)
        loadInitialdata()
    }

    private fun loadInitialdata() {
        presenter?.getWeather()
    }

    override fun showWeather(climate: String) {
        findViewById<TextView>(R.id.climaActual).text = climate
    }

    override fun showLocation(location: String) {
        findViewById<TextView>(R.id.ubicacionActual).text = location

    }
}