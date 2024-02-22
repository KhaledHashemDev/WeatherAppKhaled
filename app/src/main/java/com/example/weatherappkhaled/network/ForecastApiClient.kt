package com.example.weatherappkhaled.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ForecastApiClient {

    val api: ForecastService by lazy {
        Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ForecastService::class.java)
    }
}

