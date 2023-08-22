package com.cerengumus.bitcointrackerapp.data.repository.favorites

import androidx.lifecycle.LiveData
import com.cerengumus.bitcointrackerapp.api.Resource
import com.cerengumus.bitcointrackerapp.data.local.database.CoinsListEntity
import com.cerengumus.bitcointrackerapp.utils.GENERIC_ERROR

class FavoritesRepository(private val favoritesDataSource: FavoritesDataSource) {

    val favoriteCoins: LiveData<List<CoinsListEntity>> = favoritesDataSource.favoriteCoins

    suspend fun favoriteSymbols(): List<String> = favoritesDataSource.favouriteSymbols()

    // update favourites in local database
    suspend fun updateFavouriteStatus(symbol: String): Result<CoinsListEntity> {
        val result = favoritesDataSource.updateFavouriteStatus(symbol)
        return (result?.let {
            Resource.Success(it)
        } ?: Resource.Error(GENERIC_ERROR)) as Result<CoinsListEntity>
    }
}