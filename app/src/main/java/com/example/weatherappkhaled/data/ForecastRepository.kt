package com.example.weatherappkhaled.data

import com.example.weatherappkhaled.domain.model.ForecastResponse
import com.example.weatherappkhaled.network.ForecastApiClient
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class ForecastRepository(private val forecastApiClient: ForecastApiClient) {
    suspend fun getForecastResponse(dispatcher: CoroutineDispatcher, city: String): ForecastResponse {
        return withContext(dispatcher) {
            forecastApiClient.api.getForecast(cityName = city)
        }
    }
}

