package com.cerengumus.bitcointrackerapp.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0019\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0017H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J\u0011\u0010\u0019\u001a\u00020\u001aH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/cerengumus/bitcointrackerapp/data/FirebaseUserManager;", "", "()V", "favorites", "", "", "getFavorites", "()Ljava/util/List;", "setFavorites", "(Ljava/util/List;)V", "firebaseAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "getFirebaseAuth", "()Lcom/google/firebase/auth/FirebaseAuth;", "setFirebaseAuth", "(Lcom/google/firebase/auth/FirebaseAuth;)V", "userRef", "Lcom/google/firebase/firestore/DocumentReference;", "getUserRef", "()Lcom/google/firebase/firestore/DocumentReference;", "setUserRef", "(Lcom/google/firebase/firestore/DocumentReference;)V", "getFavoriteList", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setup", "", "app_debug"})
public final class FirebaseUserManager {
    @org.jetbrains.annotations.NotNull()
    public static final com.cerengumus.bitcointrackerapp.data.FirebaseUserManager INSTANCE = null;
    @org.jetbrains.annotations.NotNull()
    private static com.google.firebase.auth.FirebaseAuth firebaseAuth;
    @org.jetbrains.annotations.NotNull()
    private static java.util.List<java.lang.String> favorites;
    public static com.google.firebase.firestore.DocumentReference userRef;
    
    private FirebaseUserManager() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.auth.FirebaseAuth getFirebaseAuth() {
        return null;
    }
    
    public final void setFirebaseAuth(@org.jetbrains.annotations.NotNull()
    com.google.firebase.auth.FirebaseAuth p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getFavorites() {
        return null;
    }
    
    public final void setFavorites(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.firestore.DocumentReference getUserRef() {
        return null;
    }
    
    public final void setUserRef(@org.jetbrains.annotations.NotNull()
    com.google.firebase.firestore.DocumentReference p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object setup(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object getFavoriteList(kotlin.coroutines.Continuation<? super java.util.List<java.lang.String>> continuation) {
        return null;
    }
}