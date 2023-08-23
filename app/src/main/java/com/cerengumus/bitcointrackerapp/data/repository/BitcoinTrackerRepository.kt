package com.cerengumus.bitcointrackerapp.data.repository

import androidx.lifecycle.LiveData
import com.cerengumus.bitcointrackerapp.api.ApiInterface
import com.cerengumus.bitcointrackerapp.api.Resource
import com.cerengumus.bitcointrackerapp.data.local.database.CoinsListDao
import com.cerengumus.bitcointrackerapp.data.local.database.CoinsListEntity
import com.cerengumus.bitcointrackerapp.utils.GENERIC_ERROR
import retrofit2.Response

class BitcoinTrackerRepository(
    private val apiInterface: ApiInterface,
    private val coinsListDao: CoinsListDao
) {
    val allCoinsLD = coinsListDao.coinsList()
    val favoriteCoins: LiveData<List<CoinsListEntity>> = coinsListDao.favouriteCoins()

    suspend fun coinsList(targetCur: String) {
            var list = getResult {
                apiInterface.coinsList(targetCur)
            }
            if (list is Resource.Success) {
                val favSymbols = coinsListDao.favouriteSymbols()
                val customStockList = list.data.let {
                    it.filter { item -> item.symbol.isNullOrEmpty().not() }
                        .map { item ->
                            CoinsListEntity(
                                item.symbol ?: "",
                                item.id,
                                item.name,
                                item.price,
                                item.changePercent,
                                item.image,
                                favSymbols.contains(item.symbol)
                            )
                        }
                }

                coinsListDao.insert(customStockList)
                Resource.Success(true)
        } else {
                Resource.Error(GENERIC_ERROR)
        }
    }

    suspend fun updateFavouriteStatus(symbol: String): Resource<CoinsListEntity> {
        val project = coinsListDao.projectFromSymbol(symbol)
        var result: CoinsListEntity? = null
        project?.let {
            val coinsListEntity = CoinsListEntity(
                it.symbol,
                it.id,
                it.name,
                it.price,
                it.changePercent,
                it.image,
                it.isFavourite.not()
            )
            if (coinsListDao.updateCoinsListEntity(coinsListEntity) > 0) {
                result = coinsListEntity
            }
        }
        return result?.let { item ->
            Resource.Success(item)
        } ?: Resource.Error(GENERIC_ERROR)
    }

    suspend fun <T> getResult(call: suspend () -> Response<T>): Resource<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return Resource.Success(body)
            } else if (response.errorBody() != null) {
                return error(GENERIC_ERROR)
            }
            return error(GENERIC_ERROR)
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

}
