package com.cerengumus.bitcointrackerapp.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.text.DecimalFormat
import com.bumptech.glide.Glide
import com.cerengumus.bitcointrackerapp.R
import java.io.IOException
import kotlin.collections.ArrayList

fun <T> MutableLiveData<T>.observe(lifecycleOwner: LifecycleOwner, observer: Observer<T>) {
    observe(lifecycleOwner, object : Observer<T> {
        override fun onChanged(value: T) {
            observer.onChanged(value)
            if (value != null)
                removeObserver(this)
        }
    })
}
object CreateAnim {
    fun createAnimation(applicationContext: Context, animFile: Int): Animation {
        return AnimationUtils.loadAnimation(
            applicationContext,
            animFile
        )
    }
}
interface OnAnimationListener {
    fun onRepeat()
    fun onEnd()
    fun onStartAnim()
}

class StarterAnimation(
    private val resList: ArrayList<Animation>,
    private val onAnimationListener: OnAnimationListener
) {

    private var animateCount = 0
    fun startSequentialAnimation (
        view: View
    ) {
        if (resList.isNotEmpty()) {
            animateView(resList[0], view)
        } else {
            Log.d("SplashAnimation",
                "Oops!, looks like you forgot to put animation list as parameter!")
        }
    }

    private fun animateView(anim: Animation?, view: View) {
        anim?.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) { onAnimationListener.onStartAnim() }
            override fun onAnimationEnd(animation: Animation) {
                if (animateCount < resList.size) {
                    animateView(resList[animateCount], view)
                    animateCount++
                } else {
                    onAnimationListener.onEnd()
                    animateCount = 0
                }
            }
            override fun onAnimationRepeat(animation: Animation) { onAnimationListener.onRepeat() }
        })
        view.startAnimation(anim)
    }
}
fun String?.emptyIfNull(): String {
    return this ?: ""
}

fun String?.trimParanthesis(): String {
    return this?.replace(Regex("[()]"), "") ?: ""
}


fun Double?.dollarString(): String {
    return this?.let {
        val numberFormat = DecimalFormat("#,##0.00")
        "US$ ${numberFormat.format(this)}"
    } ?: ""
}

object ImageLoader {
    //Load image with Glide
    fun loadImage(
        view: ImageView,
        url: String,
        placeholder: Int = R.drawable.ic_baseline_image_24
    ) {
        Glide.with(view)
            .load(url)
            .placeholder(placeholder)
            .error(placeholder)
            .fallback(placeholder)
            .into(view)
    }
}
fun Context.isConnectedToInternet(): Boolean {
    val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networks: Array<Network> = cm.allNetworks
    var hasInternet = false
    if (networks.isNotEmpty()) {
        for (network in networks) {
            val nc = cm.getNetworkCapabilities(network)
            if (nc!!.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)) hasInternet = true
        }
    }
    return hasInternet
}
class NoConnectivityException(private val title: String = "") : IOException() {

    override val message: String?
        get() = title
}



