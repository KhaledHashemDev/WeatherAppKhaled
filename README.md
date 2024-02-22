# WeatherApp

# Overview

The Weather Forecast App is an Android application built using Kotlin and Jetpack Compose. It allows users to search for and view current weather conditions of different cities. The app fetches data from the OpenWeather API and presents a detailed view of weather parameters like temperature, humidity, and wind speed.

# Features

Search Functionality: Users can search for cities to get current weather details.
Detailed Weather Information: Displays temperature, humidity, wind speed, and other weather-related information.
Modern UI: Built using Jetpack Compose for a modern and responsive user interface.
Asynchronous Data Fetching: Utilizes Kotlin coroutines for efficient network operations.
Architecture

This app follows MVVM (Model-View-ViewModel) architecture. It uses Koin for dependency injection and Retrofit for API calls.

# Libraries and Frameworks

Jetpack Compose: For building the UI.
Retrofit: For making API requests.
Kotlin Coroutines: For managing background threads with simplified code and reducing needs for callbacks.
Koin: For dependency injection.
Gson: For JSON parsing.

# Setup

# Clone the repository.
Open the project in Android Studio.
Build and run the application on an emulator or physical device.
Usage

On launching the app, you will be greeted with a search screen.
Enter the name of the city you want to check the weather for.
Press the "Search" button to view the weather details.
API Key

The app uses the OpenWeather API. You need to insert your API key in ApiConstants object.

# Contributions

Contributions to the app are welcome. Please feel free to fork, make changes, and create a pull request.

# License

This project is licensed under the MIT License - see the LICENSE file for details.

# Acknowledgments

OpenWeather API for providing weather data.
Android and Kotlin communities for support and resources.
