package com.cerengumus.bitcointrackerapp.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.widget.ImageView
import androidx.lifecycle.Observer
import com.cerengumus.bitcointrackerapp.R
import com.cerengumus.bitcointrackerapp.ui.login.LoginScreenActivity
import com.cerengumus.bitcointrackerapp.utils.CreateAnim.createAnimation
import com.cerengumus.bitcointrackerapp.utils.OnAnimationListener
import com.cerengumus.bitcointrackerapp.utils.StarterAnimation
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashScreenActivity : AppCompatActivity() {
    private val viewModel: SplashScreenViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        viewModel.navigateToNextScreen.observe(this, Observer {
            val animList: ArrayList<Animation> = ArrayList()

            animList.add(createAnimation(applicationContext, R.anim.no_animaiton))
            animList.add(createAnimation(applicationContext, R.anim.rotate))
            animList.add(createAnimation(applicationContext, R.anim.zoom_out_fast))
            animList.add(createAnimation(applicationContext, R.anim.fade_in))

            val imageView: ImageView = findViewById(R.id.splashScreenImageView)
            StarterAnimation(
                resList = animList,
                onAnimationListener = object : OnAnimationListener {
                    override fun onRepeat() {}

                    override fun onEnd() {
                        startActivity(
                            Intent(
                                this@SplashScreenActivity,
                                LoginScreenActivity::class.java
                            )
                        )
                        finish()
                    }

                    override fun onStartAnim() {
                    }
                }
            ).startSequentialAnimation(view = imageView)
        })
    }
}