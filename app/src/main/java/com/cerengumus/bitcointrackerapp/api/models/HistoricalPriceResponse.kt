package com.cerengumus.bitcointrackerapp.api.models



data class HistoricalPriceResponse(
    val prices: List<DoubleArray>
)