package com.arjesh.boxboxassignment.di

import com.arjesh.boxboxassignment.domain.network.mainHttpClient
import org.koin.dsl.module

val networkModule = module {
    single { mainHttpClient() }
}

