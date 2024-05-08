package com.example.climap1.dagger.module

import android.content.Context
import com.example.climap1.util.SharedPreferencesConnector
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    private val cicerone: Cicerone<Router> = Cicerone.create()

    @Provides
    @Singleton
    fun provideRouter(): Router {
        return cicerone.router
    }

    @Provides
    @Singleton
    fun provideNavigatorHolder(): NavigatorHolder {
        return cicerone.getNavigatorHolder()
    }

    @Provides
    @Singleton
    fun provideSharedPreferencesConnector(): SharedPreferencesConnector {
        return SharedPreferencesConnector.getInstance(context)
    }
}