package com.example.climap1.dagger

import com.example.climap1.dagger.module.AppModule
import com.example.climap1.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}