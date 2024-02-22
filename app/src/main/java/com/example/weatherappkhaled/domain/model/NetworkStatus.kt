package com.example.weatherappkhaled.domain.model

sealed class NetworkStatus<out T> {
    object Loading : NetworkStatus<Nothing>()
    data class Success<out T>(val data: T) : NetworkStatus<T>()
    data class Failure(val error: Throwable) : NetworkStatus<Nothing>()
}
