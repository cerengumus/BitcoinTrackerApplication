package com.cerengumus.bitcointrackerapp.core.common

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.cerengumus.bitcointrackerapp.R

interface NavigationHost {
    fun registerToolbarWithNavigation(toolbar: Toolbar)
}

abstract class MainNavigationFragment : BaseFragment() {

    private var navigationHost: NavigationHost? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is NavigationHost) {
            navigationHost = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        navigationHost = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val host = navigationHost ?: return

        val mainToolbar: Toolbar = view.findViewById(R.id.toolbar) ?: return
        mainToolbar.apply {
            host.registerToolbarWithNavigation(this)
        }
    }
}