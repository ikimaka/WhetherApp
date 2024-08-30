package com.ikimaka.whetherapp.domain.repository

import com.ikimaka.whetherapp.domain.entity.City

interface SearchRepository {

    suspend fun search(query: String): List<City>
}