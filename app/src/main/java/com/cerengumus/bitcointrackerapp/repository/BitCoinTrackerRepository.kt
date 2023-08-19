package com.cerengumus.bitcointrackerapp.repository

import com.cerengumus.bitcointrackerapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import java.util.Objects

interface BitCoinTrackerRepository {
    fun getCoinDataRealTime(): Flow<Resource<List<Objects>>>
}