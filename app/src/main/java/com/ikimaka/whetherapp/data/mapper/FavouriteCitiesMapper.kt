package com.ikimaka.whetherapp.data.mapper

import com.ikimaka.whetherapp.data.local.model.CityDbModel
import com.ikimaka.whetherapp.domain.entity.City

fun City.toDbModel(): CityDbModel = CityDbModel(id, name, country)

fun CityDbModel.toEntity(): City = City(id, name, country)

fun List<CityDbModel>.toEntities(): List<City> = map { it.toEntity() }