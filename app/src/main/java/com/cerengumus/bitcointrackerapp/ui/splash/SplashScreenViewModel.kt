package com.cerengumus.bitcointrackerapp.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cerengumus.bitcointrackerapp.api.Resource
import com.cerengumus.bitcointrackerapp.utils.DELAY
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

enum class Router {
    LOGIN,
    MAIN
}

class SplashScreenViewModel(
) : ViewModel() {
    private val _navigateToNextScreen = MutableLiveData<Resource<Router>>()
    val navigateToNextScreen: LiveData<Resource<Router>> = _navigateToNextScreen

    init {
        viewModelScope.launch {
            delay(DELAY)
            _navigateToNextScreen.postValue(Resource.Success<Router>(Router.LOGIN))
        }

    }
}