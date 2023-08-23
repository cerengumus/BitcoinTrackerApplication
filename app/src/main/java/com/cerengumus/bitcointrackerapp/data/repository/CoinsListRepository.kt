package com.cerengumus.bitcointrackerapp.data.repository

import androidx.lifecycle.LiveData
import com.cerengumus.bitcointrackerapp.api.ApiInterface
import com.cerengumus.bitcointrackerapp.api.Resource
import com.cerengumus.bitcointrackerapp.data.local.database.CoinsListDao
import com.cerengumus.bitcointrackerapp.data.local.database.CoinsListEntity
import com.cerengumus.bitcointrackerapp.utils.GENERIC_ERROR
import retrofit2.Response
import java.util.*

class CoinsListRepository(
    private val apiInterface: ApiInterface,
    private val coinsListDao: CoinsListDao
) {
    private var timeLoadedAt: Long = 0
    val allCoinsLD = coinsListDao.coinsList()
    val favoriteCoins: LiveData<List<CoinsListEntity>> = coinsListDao.favouriteCoins()

    suspend fun favoriteSymbols(): List<String> = coinsListDao.favouriteSymbols()

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
        /*when (val result = getResult {
            apiInterface.coinsList(targetCur) }) {
            is Resource.Success -> {
                if (result.succeeded) {
                    val favSymbols = coinsListDao.favouriteSymbols()

                    val customStockList = result.data.let {
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

                    timeLoadedAt = Date().time

                    Resource.Success(true)
                } else {
                    Resource.Error(GENERIC_ERROR)
                }
            }
            else -> result as Resource.Error
        }*/
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

    fun loadData(): Boolean {
        val lastLoadedDate = timeLoadedAt
        val currentDataMillis = Date().time
        return currentDataMillis - lastLoadedDate > 10 * 1000
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
