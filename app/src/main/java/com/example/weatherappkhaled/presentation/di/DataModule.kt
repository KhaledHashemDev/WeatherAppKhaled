package com.example.weatherappkhaled.presentation.di

import com.example.weatherappkhaled.data.ForecastRepository
import org.koin.dsl.module

val dataModule = module {
    single { ForecastRepository(get()) }
}
