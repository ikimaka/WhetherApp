package com.ikimaka.whetherapp.data.network.dto

import com.google.gson.annotations.SerializedName

data class WeatherCurrentDto(
    @SerializedName("current") val current: WeatherDto
)
