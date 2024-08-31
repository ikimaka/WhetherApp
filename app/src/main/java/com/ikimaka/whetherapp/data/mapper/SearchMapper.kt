package com.ikimaka.whetherapp.data.mapper

import com.ikimaka.whetherapp.data.network.dto.CityDto
import com.ikimaka.whetherapp.domain.entity.City

fun CityDto.toEntity(): City = City(id, name, country)

fun List<CityDto>.toEntities(): List<City> = map { it.toEntity() }