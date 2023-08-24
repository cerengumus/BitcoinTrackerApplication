package com.cerengumus.bitcointrackerapp.ui.favourite;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J&\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eH\u0016J\u001a\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e\u00a8\u0006#"}, d2 = {"Lcom/cerengumus/bitcointrackerapp/ui/favourite/FavouriteScreenFragment;", "Lcom/cerengumus/bitcointrackerapp/core/common/MainNavigationFragment;", "Lcom/cerengumus/bitcointrackerapp/adapters/OnItemClickCallback;", "()V", "_binding", "Lcom/cerengumus/bitcointrackerapp/databinding/FragmentFavouriteScreenBinding;", "binding", "getBinding", "()Lcom/cerengumus/bitcointrackerapp/databinding/FragmentFavouriteScreenBinding;", "favouritesAdapter", "Lcom/cerengumus/bitcointrackerapp/adapters/CoinsListAdapter;", "viewModel", "Lcom/cerengumus/bitcointrackerapp/ui/favourite/FavouriteScreenViewModel;", "getViewModel", "()Lcom/cerengumus/bitcointrackerapp/ui/favourite/FavouriteScreenViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initializeViews", "", "observeViewModel", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onFavouriteClicked", "symbol", "", "onItemClick", "id", "onViewCreated", "view", "app_debug"})
public final class FavouriteScreenFragment extends com.cerengumus.bitcointrackerapp.core.common.MainNavigationFragment implements com.cerengumus.bitcointrackerapp.adapters.OnItemClickCallback {
    private final kotlin.Lazy viewModel$delegate = null;
    private com.cerengumus.bitcointrackerapp.databinding.FragmentFavouriteScreenBinding _binding;
    private com.cerengumus.bitcointrackerapp.adapters.CoinsListAdapter favouritesAdapter;
    
    public FavouriteScreenFragment() {
        super();
    }
    
    private final com.cerengumus.bitcointrackerapp.ui.favourite.FavouriteScreenViewModel getViewModel() {
        return null;
    }
    
    private final com.cerengumus.bitcointrackerapp.databinding.FragmentFavouriteScreenBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void initializeViews() {
    }
    
    @java.lang.Override()
    public void observeViewModel() {
    }
    
    @java.lang.Override()
    public void onItemClick(@org.jetbrains.annotations.NotNull()
    java.lang.String symbol, @org.jetbrains.annotations.NotNull()
    java.lang.String id) {
    }
    
    @java.lang.Override()
    public void onFavouriteClicked(@org.jetbrains.annotations.NotNull()
    java.lang.String symbol) {
    }
}