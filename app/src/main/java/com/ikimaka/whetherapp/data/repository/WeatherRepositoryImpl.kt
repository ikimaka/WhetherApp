package com.ikimaka.whetherapp.data.repository

import com.ikimaka.whetherapp.data.mapper.toEntity
import com.ikimaka.whetherapp.data.network.api.ApiService
import com.ikimaka.whetherapp.domain.entity.Forecast
import com.ikimaka.whetherapp.domain.entity.Weather
import com.ikimaka.whetherapp.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : WeatherRepository {

    override suspend fun getWeather(cityId: Int): Weather {
        return apiService.loadCurrentWeather("$PREFIX_CITY_ID$cityId").toEntity()
    }

    override suspend fun getForecast(cityId: Int): Forecast {
        return apiService.loadForecast("$PREFIX_CITY_ID$cityId").toEntity()
    }


    private companion object {

        private const val PREFIX_CITY_ID = "id:"
    }
}