package com.arjesh.boxboxassignment.di

import com.arjesh.boxboxassignment.data.remote.ApiService
import com.arjesh.boxboxassignment.data.remote.ApiServiceImpl
import com.arjesh.boxboxassignment.domain.repository.driver.DriverRepository
import com.arjesh.boxboxassignment.domain.repository.driver.DriverRepositoryImpl
import com.arjesh.boxboxassignment.domain.repository.race.RaceRepository
import com.arjesh.boxboxassignment.domain.repository.race.RaceRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<ApiService> { ApiServiceImpl(client = get()) }
    single<DriverRepository> { DriverRepositoryImpl(apiService = get()) }
    single<RaceRepository> { RaceRepositoryImpl(apiService = get()) }
}