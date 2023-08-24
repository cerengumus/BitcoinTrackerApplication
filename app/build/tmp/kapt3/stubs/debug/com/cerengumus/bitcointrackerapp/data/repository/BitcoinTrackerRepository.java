package com.cerengumus.bitcointrackerapp.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013JA\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0015\"\u0004\b\u0000\u0010\u00162\"\u0010\u0017\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00160\u001a0\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0018H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ\u001f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\u00152\u0006\u0010\u001d\u001a\u00020\u0012H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/cerengumus/bitcointrackerapp/data/repository/BitcoinTrackerRepository;", "", "apiInterface", "Lcom/cerengumus/bitcointrackerapp/api/ApiInterface;", "coinsListDao", "Lcom/cerengumus/bitcointrackerapp/data/local/database/CoinsListDao;", "(Lcom/cerengumus/bitcointrackerapp/api/ApiInterface;Lcom/cerengumus/bitcointrackerapp/data/local/database/CoinsListDao;)V", "allCoinsLD", "Landroidx/lifecycle/LiveData;", "", "Lcom/cerengumus/bitcointrackerapp/data/local/database/CoinsListEntity;", "getAllCoinsLD", "()Landroidx/lifecycle/LiveData;", "favoriteCoins", "getFavoriteCoins", "coinsList", "", "targetCur", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getResult", "Lcom/cerengumus/bitcointrackerapp/api/Resource;", "T", "call", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lretrofit2/Response;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateFavouriteStatus", "symbol", "app_debug"})
public final class BitcoinTrackerRepository {
    private final com.cerengumus.bitcointrackerapp.api.ApiInterface apiInterface = null;
    private final com.cerengumus.bitcointrackerapp.data.local.database.CoinsListDao coinsListDao = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.cerengumus.bitcointrackerapp.data.local.database.CoinsListEntity>> allCoinsLD = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.cerengumus.bitcointrackerapp.data.local.database.CoinsListEntity>> favoriteCoins = null;
    
    public BitcoinTrackerRepository(@org.jetbrains.annotations.NotNull()
    com.cerengumus.bitcointrackerapp.api.ApiInterface apiInterface, @org.jetbrains.annotations.NotNull()
    com.cerengumus.bitcointrackerapp.data.local.database.CoinsListDao coinsListDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.cerengumus.bitcointrackerapp.data.local.database.CoinsListEntity>> getAllCoinsLD() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.cerengumus.bitcointrackerapp.data.local.database.CoinsListEntity>> getFavoriteCoins() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object coinsList(@org.jetbrains.annotations.NotNull()
    java.lang.String targetCur, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateFavouriteStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String symbol, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.cerengumus.bitcointrackerapp.api.Resource<com.cerengumus.bitcointrackerapp.data.local.database.CoinsListEntity>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final <T extends java.lang.Object>java.lang.Object getResult(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super retrofit2.Response<T>>, ? extends java.lang.Object> call, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.cerengumus.bitcointrackerapp.api.Resource<? extends T>> continuation) {
        return null;
    }
}