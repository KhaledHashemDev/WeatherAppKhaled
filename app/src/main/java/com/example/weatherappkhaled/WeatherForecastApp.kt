package com.example.weatherappkhaled

import android.app.Application
import com.example.weatherappkhaled.presentation.di.dataModule
import com.example.weatherappkhaled.presentation.di.networkingModule
import com.example.weatherappkhaled.presentation.di.viewModelDiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WeatherForecastApp : Application() {

    override fun onCreate() {
        super.onCreate()

        // Start Koin
        startKoin {
            // Declare Android context
            androidContext(this@WeatherForecastApp)
            // Declare modules to use
            modules(listOf(networkingModule, dataModule, viewModelDiModule))
        }
    }
}
