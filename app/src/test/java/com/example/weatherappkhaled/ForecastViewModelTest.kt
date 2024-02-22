package com.example.weatherappkhaled

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.weatherappkhaled.data.ForecastRepository
import com.example.weatherappkhaled.domain.model.*
import com.example.weatherappkhaled.viewmodel.ForecastViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class ForecastViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: ForecastViewModel
    private val repository: ForecastRepository = mockk(relaxed = true)

    @Before
    fun setup() {
        viewModel = ForecastViewModel(repository, Dispatchers.Unconfined)
    }

    @Test
    fun getForecastIsSuccessfulUpdatesStateToSuccess() = runTest {
        val mockResponse = mockResponse
        coEvery { repository.getForecastResponse(any(), "Test City") } returns mockResponse

        viewModel.getForecast("Test City")

        val status = viewModel.forecastStatus.first()
        assertEquals(NetworkStatus.Success(mockResponse), status)
    }

    @Test
    fun `when getForecast fails, updates state to Failure`() = runTest {
        val exception = RuntimeException("Error fetching data")
        coEvery { repository.getForecastResponse(any(), "Test City") } throws exception

        viewModel.getForecast("Test City")

        val status = viewModel.forecastStatus.first()
        assertTrue(status is NetworkStatus.Failure && status.error.message == "Error fetching data")
    }
}

val mockResponse = ForecastResponse(
    base = "stations",
    clouds = Clouds(all = 90),
    cod = 200,
    coord = Coord(latitude = 40.7128, longitude = -74.0060),
    dateTime = 1589763402,
    id = 5128581,
    main = Main(
        humidity = 81,
        pressure = 1012,
        temperature = 15.0,
        maxTemperature = 16.0,
        minTemperature = 13.0,
    ),
    cityName = "New York",
    system = Sys(
        country = "US",
        id = 5410,
        message = 0.0139,
        sunrise = 1589771392,
        sunset = 1589823677,
        type = 1,
    ),
    visibility = 10000,
    weatherConditions = listOf(
        Weather(
            description = "light rain",
            icon = "10d",
            id = 500,
            main = "Rain",
        ),
    ),
    wind = Wind(
        degrees = 350,
        speed = 4.1,
    ),
)
