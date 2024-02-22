package com.example.weatherappkhaled.network

import com.example.weatherappkhaled.domain.model.ForecastResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ForecastService {

    @GET(ApiConstants.WEATHER_ENDPOINT)
    suspend fun getForecast(
        @Query("q")
        cityName: String,
        @Query("appid")
        apiKey: String = ApiConstants.OPEN_WEATHER_API_KEY,
    ): ForecastResponse
}

