package com.cerengumus.bitcointrackerapp

import com.cerengumus.bitcointarckerapp.main.MainScreenViewModel
import com.cerengumus.bitcointrackerapp.di.createOkHttpClient
import com.cerengumus.bitcointrackerapp.ui.detail.DetailScreenViewModel
import com.cerengumus.bitcointrackerapp.ui.login.LoginScreenViewModel
import com.cerengumus.bitcointrackerapp.ui.splash.SplashScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val splashViewModelModule = module {
    viewModel {
        SplashScreenViewModel()
    }
}
val mainViewModelModule = module {
    viewModel {
        MainScreenViewModel()
    }
}
val detailViewModelModule = module {
    viewModel {
        DetailScreenViewModel()
    }
}
val loginViewModelModule = module {
    viewModel {
        LoginScreenViewModel()
    }
}
val NetworkModule = module {
    single { createOkHttpClient() }
}

val modules = listOf(
    splashViewModelModule,
    mainViewModelModule,
    detailViewModelModule,
    loginViewModelModule,
)