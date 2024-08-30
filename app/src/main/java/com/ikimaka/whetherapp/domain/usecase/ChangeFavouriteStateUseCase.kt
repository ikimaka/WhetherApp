package com.ikimaka.whetherapp.domain.usecase

import com.ikimaka.whetherapp.domain.entity.City
import com.ikimaka.whetherapp.domain.repository.FavouriteRepository
import javax.inject.Inject

class ChangeFavouriteStateUseCase @Inject constructor(
    private val repository: FavouriteRepository
) {
    suspend fun addToFavourite(city: City) = repository.addToFavourite(city)

    suspend fun removeFromFavourite(cityId: Int) = repository.removeFromFavourite(cityId)
}