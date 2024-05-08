package com.example.climap1

import android.content.Intent
import com.example.climap1.ui.MainActivity
import com.github.terrakok.cicerone.androidx.ActivityScreen

object Screens {
    fun Main()= ActivityScreen {
        Intent(it, MainActivity::class.java)
    }
}