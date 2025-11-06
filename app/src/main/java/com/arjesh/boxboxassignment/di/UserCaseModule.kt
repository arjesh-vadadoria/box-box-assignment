package com.arjesh.boxboxassignment.di

import com.arjesh.boxboxassignment.domain.usecase.GetUpcomingRaceSessionUseCase
import com.arjesh.boxboxassignment.domain.usecase.GetUpcomingRaceUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetUpcomingRaceUseCase() }
    factory { GetUpcomingRaceSessionUseCase() }
}
