package com.cerengumus.bitcointrackerapp.ui.favourite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.cerengumus.bitcointrackerapp.api.Resource
import com.cerengumus.bitcointrackerapp.core.common.BaseViewModel
import com.cerengumus.bitcointrackerapp.data.local.database.CoinsListEntity
import com.cerengumus.bitcointrackerapp.data.repository.BitcoinTrackerRepository
import kotlinx.coroutines.launch

class FavouriteScreenViewModel (private val repository: BitcoinTrackerRepository) :
    BaseViewModel()  {

    val favoriteCoinsList = repository.favoriteCoins

    private val _favouriteStock = MutableLiveData<CoinsListEntity?>()
    val favouriteStock: LiveData<CoinsListEntity?> = _favouriteStock

    private val _favouritesEmpty = MutableLiveData<Boolean>()
    val favouritesEmpty: LiveData<Boolean> = _favouritesEmpty

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

    fun isFavouritemsEmpty(empty: Boolean) {
        _favouritesEmpty.value = empty
    }
}