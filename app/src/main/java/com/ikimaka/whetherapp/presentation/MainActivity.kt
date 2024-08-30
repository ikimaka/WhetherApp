package com.ikimaka.whetherapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ikimaka.whetherapp.data.network.api.ApiFactory
import com.ikimaka.whetherapp.presentation.ui.theme.WhetherAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val apiService = ApiFactory.apiService

        CoroutineScope(Dispatchers.Main).launch {
            val currentWeather = apiService.loadCurrentWeather("London")
            val forecast = apiService.loadForecast("London")
            val cities = apiService.searchCity("London")

            Log.d("MainActivity_Test", "Current Weather: $currentWeather\nForecast Weather: $forecast\nCities: $cities")
        }

        setContent {
            WhetherAppTheme {

            }
        }
    }
}
