package com.example.weatherappkhaled.presentation.di.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherappkhaled.ui.theme.WeatherAppKhaledTheme
import com.example.weatherappkhaled.viewmodel.ForecastViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel: ForecastViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppKhaledTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.onPrimary,
                ) {
                    WeatherNavHost(viewModel)
                }
            }
        }
    }
}

@Composable
fun WeatherNavHost(viewModel: ForecastViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "searchview") {
        composable("searchview") {
            MainScreen(viewModel, navController)
        }
        composable("detailview/{cityName}") { backStackEntry ->
            val cityName = backStackEntry.arguments?.getString("cityName")
            cityName?.let {
                DetailView(viewModel, navController, it)
            }
        }
    }
}

