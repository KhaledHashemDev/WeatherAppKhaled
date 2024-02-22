package com.example.weatherappkhaled.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherappkhaled.data.ForecastRepository
import com.example.weatherappkhaled.domain.model.ForecastResponse
import com.example.weatherappkhaled.domain.model.NetworkStatus
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ForecastViewModel(
    private val repository: ForecastRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val _forecastStatus = MutableStateFlow<NetworkStatus<ForecastResponse>>(NetworkStatus.Loading)
    val forecastStatus: StateFlow<NetworkStatus<ForecastResponse>> = _forecastStatus

    fun getForecast(cityName: String) {
        viewModelScope.launch(dispatcher) {
            try {
                _forecastStatus.value = NetworkStatus.Loading
                val response = repository.getForecastResponse(dispatcher, cityName)
                _forecastStatus.value = NetworkStatus.Success(response)
            } catch (e: Exception) {
                _forecastStatus.value = NetworkStatus.Failure(e)
            }
        }
    }
}