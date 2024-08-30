package com.ikimaka.whetherapp.domain.repository

import com.ikimaka.whetherapp.domain.entity.City
import com.ikimaka.whetherapp.domain.entity.Forecast
import com.ikimaka.whetherapp.domain.entity.Weather
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {

    suspend fun getWeather(cityId: Int): Weather

    suspend fun getForecast(cityId: Int): Forecast
}