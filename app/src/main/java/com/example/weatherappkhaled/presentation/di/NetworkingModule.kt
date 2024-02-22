package com.example.weatherappkhaled.presentation.di

import com.example.weatherappkhaled.network.ApiConstants
import com.example.weatherappkhaled.network.ForecastApiClient
import com.example.weatherappkhaled.network.ForecastService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkingModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(ForecastService::class.java) }

    single { ForecastApiClient() }
}

