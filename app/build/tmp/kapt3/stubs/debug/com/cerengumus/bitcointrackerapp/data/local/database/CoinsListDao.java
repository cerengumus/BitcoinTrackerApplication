package com.cerengumus.bitcointrackerapp.data.local.database;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u0011\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u001f\u0010\r\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0011\u001a\u00020\u000bH\'J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lcom/cerengumus/bitcointrackerapp/data/local/database/CoinsListDao;", "", "coinsList", "Landroidx/lifecycle/LiveData;", "", "Lcom/cerengumus/bitcointrackerapp/data/local/database/CoinsListEntity;", "deleteAll", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "favouriteCoins", "favouriteSymbols", "", "getCoinInfoList", "insert", "coinList", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "projectFromSymbol", "symbol", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "projectLiveDataFromSymbol", "updateCoinsListEntity", "", "data", "(Lcom/cerengumus/bitcointrackerapp/data/local/database/CoinsListEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface CoinsListDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM coins_list")
    public abstract java.lang.Object getCoinInfoList(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.cerengumus.bitcointrackerapp.data.local.database.CoinsListEntity>> continuation);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "Select * from coins_list")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.cerengumus.bitcointrackerapp.data.local.database.CoinsListEntity>> coinsList();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "Select * from coins_list where symbol = :symbol")
    public abstract java.lang.Object projectFromSymbol(@org.jetbrains.annotations.NotNull()
    java.lang.String symbol, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.cerengumus.bitcointrackerapp.data.local.database.CoinsListEntity> continuation);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "Select * from coins_list where symbol = :symbol")
    public abstract androidx.lifecycle.LiveData<com.cerengumus.bitcointrackerapp.data.local.database.CoinsListEntity> projectLiveDataFromSymbol(@org.jetbrains.annotations.NotNull()
    java.lang.String symbol);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "Select * from coins_list where isFavourite = 1")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.cerengumus.bitcointrackerapp.data.local.database.CoinsListEntity>> favouriteCoins();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "Select symbol from coins_list where isFavourite = 1")
    public abstract java.lang.Object favouriteSymbols(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<java.lang.String>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = 1)
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    java.util.List<com.cerengumus.bitcointrackerapp.data.local.database.CoinsListEntity> coinList, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Update()
    public abstract java.lang.Object updateCoinsListEntity(@org.jetbrains.annotations.NotNull()
    com.cerengumus.bitcointrackerapp.data.local.database.CoinsListEntity data, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "Delete from coins_list")
    public abstract java.lang.Object deleteAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}