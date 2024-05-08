package com.example.climap1

import android.app.Application
import com.example.climap1.dagger.AppComponent
import com.example.climap1.dagger.DaggerAppComponent
import com.example.climap1.dagger.module.AppModule

class BaseApplication : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    companion object {
        lateinit var INSTANCE: BaseApplication
    }
}