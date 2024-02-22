package com.example.weatherappkhaled.domain.model

import com.google.gson.annotations.SerializedName

data class ForecastResponse(
    @SerializedName("base")
    val base: String,

    @SerializedName("clouds")
    val clouds: Clouds,

    @SerializedName("cod")
    val cod: Int,

    @SerializedName("coord")
    val coord: Coord,

    @SerializedName("dt")
    val dateTime: Int,

    @SerializedName("id")
    val id: Int,

    @SerializedName("main")
    val main: Main,

    @SerializedName("name")
    val cityName: String,

    @SerializedName("sys")
    val system: Sys,

    @SerializedName("visibility")
    val visibility: Int,

    @SerializedName("weather")
    val weatherConditions: List<Weather>,

    @SerializedName("wind")
    val wind: Wind
)

data class Clouds(
    @SerializedName("all")
    val all: Int
)

data class Coord(
    @SerializedName("lat")
    val latitude: Double,

    @SerializedName("lon")
    val longitude: Double
)

data class Main(
    @SerializedName("humidity")
    val humidity: Int,

    @SerializedName("pressure")
    val pressure: Int,

    @SerializedName("temp")
    val temperature: Double,

    @SerializedName("temp_max")
    val maxTemperature: Double,

    @SerializedName("temp_min")
    val minTemperature: Double
)

data class Sys(
    @SerializedName("country")
    val country: String,

    @SerializedName("id")
    val id: Int,

    @SerializedName("message")
    val message: Double,

    @SerializedName("sunrise")
    val sunrise: Int,

    @SerializedName("sunset")
    val sunset: Int,

    @SerializedName("type")
    val type: Int
)

data class Weather(
    @SerializedName("description")
    val description: String,

    @SerializedName("icon")
    val icon: String,

    @SerializedName("id")
    val id: Int,

    @SerializedName("main")
    val main: String
)

data class Wind(
    @SerializedName("deg")
    val degrees: Int,

    @SerializedName("speed")
    val speed: Double
)
