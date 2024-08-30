package com.ikimaka.whetherapp.data.network.api

import com.ikimaka.whetherapp.data.network.dto.CityDto
import com.ikimaka.whetherapp.data.network.dto.WeatherCurrentDto
import com.ikimaka.whetherapp.data.network.dto.WeatherForecastDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("current.json?key=cab39c7295be43458e6163156243008")
    suspend fun loadCurrentWeather(
        @Query("q") query: String
    ): WeatherCurrentDto

    @GET("forecast.json?key=cab39c7295be43458e6163156243008")
    suspend fun loadForecast(
        @Query("q") query: String,
        @Query("days") daysCount: Int = 4
    ): WeatherForecastDto

    @GET("search.json?key=cab39c7295be43458e6163156243008")
    suspend fun searchCity(
        @Query("q") query: String
    ): List<CityDto>
}