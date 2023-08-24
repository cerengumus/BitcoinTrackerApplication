package com.cerengumus.bitcointrackerapp.ui.main;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0016\u001a\u00020\u0017J\u001a\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00172\b\b\u0002\u0010\u001b\u001a\u00020\nJ\u0006\u0010\u001c\u001a\u00020\u0019J\u0006\u0010\u001d\u001a\u00020\u0019J\u000e\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\nR\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000f\u00a8\u0006 "}, d2 = {"Lcom/cerengumus/bitcointrackerapp/ui/main/MainViewModel;", "Lcom/cerengumus/bitcointrackerapp/core/common/BaseViewModel;", "repository", "Lcom/cerengumus/bitcointrackerapp/data/repository/BitcoinTrackerRepository;", "(Lcom/cerengumus/bitcointrackerapp/data/repository/BitcoinTrackerRepository;)V", "_favouriteStock", "Landroidx/lifecycle/MutableLiveData;", "Lcom/cerengumus/bitcointrackerapp/data/local/database/CoinsListEntity;", "_warningEvent", "Lcom/cerengumus/bitcointrackerapp/utils/Event;", "", "coinsListData", "Landroidx/lifecycle/LiveData;", "", "getCoinsListData", "()Landroidx/lifecycle/LiveData;", "favouriteStock", "getFavouriteStock", "timer", "Ljava/util/Timer;", "warningEvent", "getWarningEvent", "isListEmpty", "", "loadCoinsFromApi", "", "showBusy", "targetCur", "startTimer", "stopTimer", "updateFavouriteStatus", "symbol", "app_debug"})
public final class MainViewModel extends com.cerengumus.bitcointrackerapp.core.common.BaseViewModel {
    private final com.cerengumus.bitcointrackerapp.data.repository.BitcoinTrackerRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.cerengumus.bitcointrackerapp.data.local.database.CoinsListEntity>> coinsListData = null;
    private final androidx.lifecycle.MutableLiveData<com.cerengumus.bitcointrackerapp.data.local.database.CoinsListEntity> _favouriteStock = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.cerengumus.bitcointrackerapp.data.local.database.CoinsListEntity> favouriteStock = null;
    private final androidx.lifecycle.MutableLiveData<com.cerengumus.bitcointrackerapp.utils.Event<java.lang.String>> _warningEvent = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.cerengumus.bitcointrackerapp.utils.Event<java.lang.String>> warningEvent = null;
    private java.util.Timer timer;
    
    public MainViewModel(@org.jetbrains.annotations.NotNull()
    com.cerengumus.bitcointrackerapp.data.repository.BitcoinTrackerRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.cerengumus.bitcointrackerapp.data.local.database.CoinsListEntity>> getCoinsListData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.cerengumus.bitcointrackerapp.data.local.database.CoinsListEntity> getFavouriteStock() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.cerengumus.bitcointrackerapp.utils.Event<java.lang.String>> getWarningEvent() {
        return null;
    }
    
    public final boolean isListEmpty() {
        return false;
    }
    
    public final void loadCoinsFromApi(boolean showBusy, @org.jetbrains.annotations.NotNull()
    java.lang.String targetCur) {
    }
    
    public final void updateFavouriteStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String symbol) {
    }
    
    public final void startTimer() {
    }
    
    public final void stopTimer() {
    }
}