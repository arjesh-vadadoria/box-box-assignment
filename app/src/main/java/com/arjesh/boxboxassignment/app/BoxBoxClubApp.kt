package com.arjesh.boxboxassignment.app

import android.app.Application
import com.arjesh.boxboxassignment.di.networkModule
import com.arjesh.boxboxassignment.di.repositoryModule
import com.arjesh.boxboxassignment.di.useCaseModule
import com.arjesh.boxboxassignment.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class BoxBoxClubApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@BoxBoxClubApp)
            modules(
                networkModule,
                repositoryModule,
                viewModelModule,
                useCaseModule,
            )
        }

    }
}