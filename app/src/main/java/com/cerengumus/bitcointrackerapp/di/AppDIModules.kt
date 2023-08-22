package com.cerengumus.bitcointrackerapp

import android.content.Context
import androidx.room.Room
import com.cerengumus.bitcointrackerapp.api.ApiInterface
import com.cerengumus.bitcointrackerapp.data.FirebaseUserManager
import com.cerengumus.bitcointrackerapp.data.local.database.CoinsDatabase
import com.cerengumus.bitcointrackerapp.data.local.database.CoinsListDao
import com.cerengumus.bitcointrackerapp.data.local.database.DB.DATABASE_NAME
import com.cerengumus.bitcointrackerapp.data.repository.coinsList.CoinsListRepository
import com.cerengumus.bitcointrackerapp.di.createOkHttpClient
import com.cerengumus.bitcointrackerapp.ui.detail.DetailScreenViewModel
import com.cerengumus.bitcointrackerapp.ui.favourite.FavouriteScreenViewModel
import com.cerengumus.bitcointrackerapp.ui.login.LoginScreenViewModel
import com.cerengumus.bitcointrackerapp.ui.main.MainViewModel
import com.cerengumus.bitcointrackerapp.ui.splash.SplashScreenViewModel
import com.cerengumus.bitcointrackerapp.utils.BASE_URL
import com.meliksahcakir.cointracker.utils.NetworkConnectionInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val repositoryModule = module {
    fun provideCoinDao(db: CoinsDatabase): CoinsListDao {
        return db.coinsListDao()
    }
    single { CoinsListRepository(get(), provideCoinDao(get())) }
}
val databaseModule = module {

    fun provideDatabase(context: Context): CoinsDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            CoinsDatabase::class.java,
            DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }

    single { provideDatabase(androidContext()) }
}
val retrofitModule = module {

    fun provideHttpClient(context: Context): OkHttpClient {
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BASIC
        val networkInterceptor = NetworkConnectionInterceptor(context)
        return OkHttpClient.Builder()
            .addInterceptor(logger)
            .addInterceptor(networkInterceptor)
            .build()
    }

    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { provideHttpClient(androidContext()) }
    single { provideRetrofit(get()) }
}

val apiModule = module {

    fun provideApi(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }

    single { provideApi(get()) }
}

val mainViewModelModule = module {
    viewModel {
        MainViewModel(get())
    }
}
val splashViewModelModule = module {
    viewModel {
        SplashScreenViewModel()
    }
}
val favouriteViewModelModule = module {
    viewModel {
        FavouriteScreenViewModel()
    }
}
val detailViewModelModule = module {
    viewModel {
        DetailScreenViewModel()
    }
}
val loginViewModelModule = module {
    viewModel {
        LoginScreenViewModel(FirebaseUserManager)
    }
}
val NetworkModule = module {
    single { createOkHttpClient() }
}

val modules = listOf(
    splashViewModelModule,
    loginViewModelModule,
    mainViewModelModule,
    detailViewModelModule,
    favouriteViewModelModule,
    repositoryModule,
    databaseModule,
    retrofitModule,
    apiModule,
    NetworkModule
)