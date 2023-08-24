package com.cerengumus.bitcointrackerapp.ui.login;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\u000e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/cerengumus/bitcointrackerapp/ui/login/LoginScreenViewModel;", "Landroidx/lifecycle/ViewModel;", "firebaseUserManager", "Lcom/cerengumus/bitcointrackerapp/data/FirebaseUserManager;", "(Lcom/cerengumus/bitcointrackerapp/data/FirebaseUserManager;)V", "_availability", "Landroidx/lifecycle/MutableLiveData;", "", "_navigateToNextScreen", "Lcom/cerengumus/bitcointrackerapp/utils/Event;", "", "availability", "Landroidx/lifecycle/LiveData;", "getAvailability", "()Landroidx/lifecycle/LiveData;", "navigateToNextScreen", "getNavigateToNextScreen", "controlFirebaseUser", "Lcom/google/firebase/auth/FirebaseUser;", "login", "Lcom/cerengumus/bitcointrackerapp/api/Resource;", "data", "Landroid/content/Intent;", "(Landroid/content/Intent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signIn", "app_debug"})
public final class LoginScreenViewModel extends androidx.lifecycle.ViewModel {
    private final com.cerengumus.bitcointrackerapp.data.FirebaseUserManager firebaseUserManager = null;
    private final androidx.lifecycle.MutableLiveData<com.cerengumus.bitcointrackerapp.utils.Event<kotlin.Unit>> _navigateToNextScreen = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.cerengumus.bitcointrackerapp.utils.Event<kotlin.Unit>> navigateToNextScreen = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _availability = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> availability = null;
    
    public LoginScreenViewModel(@org.jetbrains.annotations.NotNull()
    com.cerengumus.bitcointrackerapp.data.FirebaseUserManager firebaseUserManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.cerengumus.bitcointrackerapp.utils.Event<kotlin.Unit>> getNavigateToNextScreen() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getAvailability() {
        return null;
    }
    
    public final void signIn(@org.jetbrains.annotations.NotNull()
    android.content.Intent data) {
    }
    
    private final java.lang.Object login(android.content.Intent data, kotlin.coroutines.Continuation<? super com.cerengumus.bitcointrackerapp.api.Resource<? extends com.google.firebase.auth.FirebaseUser>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.firebase.auth.FirebaseUser controlFirebaseUser() {
        return null;
    }
}