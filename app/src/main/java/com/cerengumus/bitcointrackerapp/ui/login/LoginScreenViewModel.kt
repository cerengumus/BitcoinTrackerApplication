package com.cerengumus.bitcointrackerapp.ui.login

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cerengumus.bitcointrackerapp.api.Resource
import com.cerengumus.bitcointrackerapp.data.FirebaseUserManager
import com.google.android.gms.auth.api.Auth
import com.google.firebase.auth.GoogleAuthProvider
import com.cerengumus.bitcointrackerapp.utils.Event
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class LoginScreenViewModel(
    private val firebaseUserManager: FirebaseUserManager
) : ViewModel() {
    private val _navigateToNextScreen = MutableLiveData<Event<Unit>>()
    val navigateToNextScreen: LiveData<Event<Unit>> = _navigateToNextScreen

    private val _availability = MutableLiveData<Boolean>(false)
    val availability: LiveData<Boolean> = _availability

    fun signIn(data: Intent) {
        viewModelScope.launch {
            _availability.value = true
            val response = login(data)
            if (response is Resource.Success) {
                firebaseUserManager.setup()
                _navigateToNextScreen.value = Event(Unit)
            }

        }
    }

    private suspend fun login(data: Intent): Resource<FirebaseUser> {
        return try {
            val response = Auth.GoogleSignInApi.getSignInResultFromIntent(data)
            response?.isSuccess.let { result ->
                val account = response?.signInAccount
                val credential = GoogleAuthProvider.getCredential(account?.idToken, null)
                firebaseUserManager.firebaseAuth.signInWithCredential(credential).await()

            }
            val user = firebaseUserManager.firebaseAuth.currentUser
            if (user != null) {
                Resource.Success(user)
            } else {
                Resource.Error("User not found")
            }
        } catch (e: Exception) {
            Resource.Error(e.toString())
        }

    }
    fun controlFirebaseUser() : FirebaseUser? {
        val firebaseUser = firebaseUserManager.firebaseAuth.currentUser
        if (firebaseUser != null) {
            viewModelScope.launch {
                firebaseUserManager.setup()
                _navigateToNextScreen.value = Event(Unit)
            }
        }
        return firebaseUser
    }
}
