package com.cerengumus.bitcointrackerapp.api

import com.cerengumus.bitcointrackerapp.api.models.Coin
import com.cerengumus.bitcointrackerapp.api.models.PriceHistoryDetailResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("coins/list")
    suspend fun getCoinInfoList(): List<Coin>

    @GET(ServiceEndPoints.COINS_LIST)
    suspend fun coinsList(@Query("vs_currency") targetCurrency: String): Response<List<Coin>>

    @GET(ServiceEndPoints.COINS)
    suspend fun historicalPrice(
        @Path("id") id: String,
        @Query("vs_currency") targetCurrency: String,
        @Query("days") days: Int
    ): Response<PriceHistoryDetailResponse>

}
