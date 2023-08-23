package com.cerengumus.bitcointrackerapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.cerengumus.bitcointrackerapp.api.Resource
import com.cerengumus.bitcointrackerapp.core.common.BaseViewModel
import com.cerengumus.bitcointrackerapp.data.local.database.CoinsListEntity
import com.cerengumus.bitcointrackerapp.data.repository.CoinsListRepository
import com.cerengumus.bitcointrackerapp.utils.Event
import com.cerengumus.bitcointrackerapp.utils.FETCH_INTERVAL
import kotlinx.coroutines.launch
import java.util.*

class MainViewModel (private val repository: CoinsListRepository) :
    BaseViewModel() {

    val coinsListData = repository.allCoinsLD

    private val _favouriteStock = MutableLiveData<CoinsListEntity?>()
    val favouriteStock: LiveData<CoinsListEntity?> = _favouriteStock

    private val _warningEvent = MutableLiveData<Event<String>>()
    val warningEvent: LiveData<Event<String>> = _warningEvent

    private var timer: Timer? = null

    init {
        loadCoinsFromApi(true, "usd")
    }

    fun isListEmpty(): Boolean {
        return coinsListData.value?.isEmpty() ?: true
    }

    fun loadCoinsFromApi(showBusy: Boolean = false,targetCur: String = "usd") {
            viewModelScope.launch {
                if (showBusy) {
                    _isLoading.value = true
                }
                repository.coinsList(targetCur)
                if (showBusy) {
                    _isLoading.value = false
                }
            }

    }

    fun updateFavouriteStatus(symbol: String) {
        viewModelScope.launch {
            val result = repository.updateFavouriteStatus(symbol)
            when (result) {
                is Resource.Success -> _favouriteStock.value = result.data
                is Resource.Error -> _toastError.value = result.message
                else -> {}
            }
        }
    }

    fun startTimer() {
        timer?.cancel()
        timer = Timer()
        timer?.scheduleAtFixedRate(
            object : TimerTask() {
                override fun run() {
                    loadCoinsFromApi()
                }
            },
            FETCH_INTERVAL,
            FETCH_INTERVAL
        )
    }

    fun stopTimer() {
        timer?.cancel()
        timer = null
    }

}