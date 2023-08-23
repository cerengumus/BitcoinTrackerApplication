package com.cerengumus.bitcointrackerapp.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

object FirebaseUserManager {
    var firebaseAuth = FirebaseAuth.getInstance()
    var favorites = mutableListOf<String>()

    lateinit var userRef: DocumentReference

    suspend fun setup() {
        val uid = firebaseAuth.currentUser?.uid ?: return
        userRef = Firebase.firestore.collection("users").document(uid)
        getFavoriteList()?.let {
            favorites = it.toMutableList()
        }
    }

    private suspend fun getFavoriteList(): List<String>? {
        return withContext(Dispatchers.IO) {
            try {
                val snapshot = userRef.get().await()
                snapshot.get("favorites") as? List<String>
            } catch (e: Exception) {
                null
            }
        }
    }
}