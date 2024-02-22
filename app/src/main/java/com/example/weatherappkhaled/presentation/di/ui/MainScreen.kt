package com.example.weatherappkhaled.presentation.di.ui

import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.weatherappkhaled.viewmodel.ForecastViewModel

@Composable
fun MainScreen(viewModel: ForecastViewModel, navController: NavHostController) {
    var inputCity by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        TextField(
            value = inputCity,
            onValueChange = { inputCity = it },
            label = { Text("Enter City Name") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            viewModel.getForecast(inputCity)
            navController.navigate("detailview/$inputCity")
        }) {
            Text("Search")
        }
    }
}
