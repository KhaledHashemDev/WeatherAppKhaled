package com.example.weatherappkhaled.presentation.di

import com.example.weatherappkhaled.viewmodel.ForecastViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelDiModule = module {
    viewModel { ForecastViewModel(get()) }
}
