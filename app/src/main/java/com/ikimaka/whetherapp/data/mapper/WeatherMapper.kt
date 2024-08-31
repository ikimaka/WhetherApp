package com.ikimaka.whetherapp.data.mapper

import com.ikimaka.whetherapp.data.network.dto.WeatherCurrentDto
import com.ikimaka.whetherapp.data.network.dto.WeatherDto
import com.ikimaka.whetherapp.data.network.dto.WeatherForecastDto
import com.ikimaka.whetherapp.domain.entity.Forecast
import com.ikimaka.whetherapp.domain.entity.Weather
import java.util.Calendar
import java.util.Date

fun WeatherCurrentDto.toEntity(): Weather = current.toEntity()

fun WeatherDto.toEntity(): Weather = Weather(
    tempC = tempC,
    conditionText = condition.text,
    conditionUrl = condition.iconUrl.correctImageUrl(),
    date = date.toCalendar()
)

fun WeatherForecastDto.toEntity() = Forecast(
    currentWeather = current.toEntity(),
    upcoming = forecastDto.forecastDay.drop(1).map { dayDto ->
        val dayWeatherDto = dayDto.dayWeatherDto
        Weather(
            tempC = dayWeatherDto.tempC,
            conditionText = dayWeatherDto.condition.text,
            conditionUrl = dayWeatherDto.condition.iconUrl.correctImageUrl(),
            date = dayDto.date.toCalendar()
        )
    }
)

private fun Long.toCalendar() = Calendar.getInstance().apply {
    time = Date(this@toCalendar * 1000)
}

private fun String.correctImageUrl() = "https:$this".replace(
    oldValue = "64x64",
    newValue = "128x128"
)