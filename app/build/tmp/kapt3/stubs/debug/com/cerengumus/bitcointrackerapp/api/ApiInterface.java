package com.cerengumus.bitcointrackerapp.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\'\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ5\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\r\u001a\u00020\u00072\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/cerengumus/bitcointrackerapp/api/ApiInterface;", "", "coinsList", "Lretrofit2/Response;", "", "Lcom/cerengumus/bitcointrackerapp/api/models/Coin;", "targetCurrency", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCoinInfoList", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "historicalPrice", "Lcom/cerengumus/bitcointrackerapp/api/models/PriceHistoryDetailResponse;", "id", "days", "", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ApiInterface {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "coins/list")
    public abstract java.lang.Object getCoinInfoList(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.cerengumus.bitcointrackerapp.api.models.Coin>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "coins/markets")
    public abstract java.lang.Object coinsList(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "vs_currency")
    java.lang.String targetCurrency, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.cerengumus.bitcointrackerapp.api.models.Coin>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "coins/{id}/market_chart")
    public abstract java.lang.Object historicalPrice(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "id")
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "vs_currency")
    java.lang.String targetCurrency, @retrofit2.http.Query(value = "days")
    int days, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.cerengumus.bitcointrackerapp.api.models.PriceHistoryDetailResponse>> continuation);
}