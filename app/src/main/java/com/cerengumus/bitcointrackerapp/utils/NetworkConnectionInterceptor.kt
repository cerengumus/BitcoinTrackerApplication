package com.meliksahcakir.cointracker.utils

import android.content.Context
import com.cerengumus.bitcointrackerapp.R
import com.cerengumus.bitcointrackerapp.utils.NoConnectivityException
import com.cerengumus.bitcointrackerapp.utils.isConnectedToInternet
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class NetworkConnectionInterceptor(private val context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!context.isConnectedToInternet()) {
            throw NoConnectivityException("Internet yok")
        }
        val builder: Request.Builder = chain.request().newBuilder()
        return chain.proceed(builder.build())
    }
}
