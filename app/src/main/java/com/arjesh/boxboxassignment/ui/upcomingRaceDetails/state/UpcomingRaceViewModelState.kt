package com.arjesh.boxboxassignment.ui.upcomingRaceDetails.state

import com.arjesh.boxboxassignment.base.BaseUiState
import com.arjesh.boxboxassignment.base.BaseViewModelState
import com.arjesh.boxboxassignment.data.model.RaceSchedules

data class UpcomingRaceViewModelState(
    val race: RaceSchedules.Schedule? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
) : BaseViewModelState {
    override fun toUiState(): BaseUiState {
        return UpcomingRaceUiState(
            race = race,
            isLoading = isLoading,
            error = error,
        )
    }
}
