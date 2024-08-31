package com.ikimaka.whetherapp.data.repository

import com.ikimaka.whetherapp.data.mapper.toEntities
import com.ikimaka.whetherapp.data.network.api.ApiService
import com.ikimaka.whetherapp.domain.entity.City
import com.ikimaka.whetherapp.domain.repository.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : SearchRepository {

    override suspend fun search(query: String): List<City> {
        return apiService.searchCity(query).toEntities()
    }
}