package com.arjesh.boxboxassignment.ui.upcomingRaceDetails.state

import com.arjesh.boxboxassignment.base.BaseUiState
import com.arjesh.boxboxassignment.data.model.RaceSchedules

data class UpcomingRaceUiState(
    val race: RaceSchedules.Schedule?,
    val isLoading: Boolean,
    val error: String?,
) : BaseUiState