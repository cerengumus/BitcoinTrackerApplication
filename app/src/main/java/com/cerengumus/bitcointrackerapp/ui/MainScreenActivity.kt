package com.cerengumus.bitcointrackerapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.cerengumus.bitcointrackerapp.R
import androidx.core.view.isVisible
import androidx.navigation.NavDestination
import androidx.navigation.ui.AppBarConfiguration
import com.cerengumus.bitcointrackerapp.databinding.ActivityMainBinding


class MainScreenActivity : AppCompatActivity(),
    NavController.OnDestinationChangedListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    private var navHostFragment: NavHostFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navHostFragment = supportFragmentManager.findFragmentById(R.id.homeNavHostFragment) as NavHostFragment
        binding.homeBottomNavView.setupWithNavController(navHostFragment!!.navController)
        navHostFragment!!.navController.addOnDestinationChangedListener(this)
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        when (destination.id) {
            R.id.mainFragment -> binding.homeBottomNavView.isVisible = true
            R.id.favoriteFragment -> binding.homeBottomNavView.isVisible = true
            else -> binding.homeBottomNavView.isVisible = false
        }
    }
}