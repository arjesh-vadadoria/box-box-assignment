package com.arjesh.boxboxassignment.ui.upcomingRaceDetails

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.toRoute
import com.arjesh.boxboxassignment.base.BaseViewModel
import com.arjesh.boxboxassignment.data.model.RaceSchedules
import com.arjesh.boxboxassignment.ui.home.state.HomeEffect
import com.arjesh.boxboxassignment.ui.navigation.Route
import com.arjesh.boxboxassignment.ui.upcomingRaceDetails.state.UpcomingRaceUiState
import com.arjesh.boxboxassignment.ui.upcomingRaceDetails.state.UpcomingRaceViewModelState
import com.arjesh.boxboxassignment.utils.getDisplayRaceStartEndTime
import kotlinx.coroutines.flow.update
import kotlinx.serialization.json.Json

class UpcomingRaceDetailsViewModel(
    savedStateHandle: SavedStateHandle,
) : BaseViewModel<UpcomingRaceViewModelState, UpcomingRaceUiState, HomeEffect>(initialState = UpcomingRaceViewModelState()) {

    private val upcomingRoute = savedStateHandle.toRoute<Route.UpcomingRaceDetails>()

    init {
        val race = Json.decodeFromString<RaceSchedules.Schedule>(upcomingRoute.raceSchedule)
        viewModelState.update {
            it.copy(
                race = race.copy(
                    displayStartEndTime = getDisplayRaceStartEndTime(
                        race.raceStartTime,
                        race.raceEndTime
                    )
                )
            )
        }
    }

}