package com.ikimaka.whetherapp.di

import android.content.Context
import com.ikimaka.whetherapp.data.local.db.FavouriteCitiesDao
import com.ikimaka.whetherapp.data.local.db.FavouriteDatabase
import com.ikimaka.whetherapp.data.network.api.ApiFactory
import com.ikimaka.whetherapp.data.network.api.ApiService
import com.ikimaka.whetherapp.data.repository.FavouriteRepositoryImpl
import com.ikimaka.whetherapp.data.repository.SearchRepositoryImpl
import com.ikimaka.whetherapp.data.repository.WeatherRepositoryImpl
import com.ikimaka.whetherapp.domain.repository.FavouriteRepository
import com.ikimaka.whetherapp.domain.repository.SearchRepository
import com.ikimaka.whetherapp.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindFavouriteRepository(impl: FavouriteRepositoryImpl): FavouriteRepository

    @ApplicationScope
    @Binds
    fun bindWeatherRepository(impl: WeatherRepositoryImpl): WeatherRepository

    @ApplicationScope
    @Binds
    fun bindSearchRepository(impl: SearchRepositoryImpl): SearchRepository

    companion object {

        @ApplicationScope
        @Provides
        fun provideApiService(): ApiService = ApiFactory.apiService

        @ApplicationScope
        @Provides
        fun provideFavouriteDatabase(
            context: Context
        ): FavouriteDatabase {
            return FavouriteDatabase.getInstance(context)
        }

        @ApplicationScope
        @Provides
        fun provideFavouriteCitiesDao(
            database: FavouriteDatabase
        ): FavouriteCitiesDao {
            return database.favouriteCitiesDao()
        }
    }
}