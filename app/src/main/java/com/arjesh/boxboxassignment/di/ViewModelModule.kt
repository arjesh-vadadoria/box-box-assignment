package com.arjesh.boxboxassignment.di

import com.arjesh.boxboxassignment.ui.home.HomeViewModel
import com.arjesh.boxboxassignment.ui.upcomingRaceDetails.UpcomingRaceDetailsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        HomeViewModel(
            driverRepository = get(),
            raceRepository = get(),
            getUpcomingRaceUseCase = get(),
            getUpcomingRaceSessionUseCase = get(),
        )
    }

    viewModel {
        UpcomingRaceDetailsViewModel(
            savedStateHandle = get()
        )
    }
}