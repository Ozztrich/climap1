package com.example.climap1.dagger.module

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.google.android.datatransport.runtime.dagger.Module
import com.google.android.datatransport.runtime.dagger.Provides
import javax.inject.Singleton

@Module
class MainModule {
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
    
}