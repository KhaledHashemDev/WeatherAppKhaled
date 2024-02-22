package com.example.weatherappkhaled.presentation.di.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.weatherappkhaled.domain.model.ForecastResponse
import com.example.weatherappkhaled.domain.model.NetworkStatus
import com.example.weatherappkhaled.viewmodel.ForecastViewModel

@Composable
fun DetailView(viewModel: ForecastViewModel, navController: NavHostController, cityName: String) {
    val weatherResponse by viewModel.forecastStatus.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        when (val response = weatherResponse) {
            is NetworkStatus.Loading -> CircularProgressIndicator()
            is NetworkStatus.Success<*> -> {
                // Explicitly cast the success data to ForecastResponse
                (response.data as? ForecastResponse)?.let { forecast ->
                    Text(text = "Weather in $cityName", style = MaterialTheme.typography.headlineMedium)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Temperature: ${forecast.main.temperature}°")
                    Text("Humidity: ${forecast.main.humidity}%")
                } ?: Text("Invalid weather data")
            }
            is NetworkStatus.Failure -> {
                Text("Failed to load data for $cityName")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("searchview") }) {
            Text("Back to Search")
        }
    }
}


