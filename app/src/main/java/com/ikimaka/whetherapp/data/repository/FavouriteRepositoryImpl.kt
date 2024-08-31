package com.ikimaka.whetherapp.data.repository

import com.ikimaka.whetherapp.data.local.db.FavouriteCitiesDao
import com.ikimaka.whetherapp.data.mapper.toDbModel
import com.ikimaka.whetherapp.data.mapper.toEntities
import com.ikimaka.whetherapp.domain.entity.City
import com.ikimaka.whetherapp.domain.repository.FavouriteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FavouriteRepositoryImpl @Inject constructor(
    private val favouriteCitiesDao: FavouriteCitiesDao
) : FavouriteRepository {

    override val favouriteCities: Flow<List<City>> = favouriteCitiesDao.getFavouriteCities()
        .map { it.toEntities() }

    override fun observeIsFavourite(cityId: Int): Flow<Boolean> = favouriteCitiesDao.observeIsFavourite(cityId)

    override suspend fun addToFavourite(city: City) {
        favouriteCitiesDao.addToFavourite(city.toDbModel())
    }

    override suspend fun removeFromFavourite(cityId: Int) {
        favouriteCitiesDao.removeFromFavourite(cityId)
    }
}