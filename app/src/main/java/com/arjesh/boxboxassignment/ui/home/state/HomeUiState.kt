package com.arjesh.boxboxassignment.ui.home.state

import com.arjesh.boxboxassignment.base.BaseUiState
import com.arjesh.boxboxassignment.data.model.Drivers
import com.arjesh.boxboxassignment.data.model.RaceSchedules

data class HomeUiState(
    val firstPositionDriver: Drivers.Driver?,
    val sessionName: String?,
    val sessionDate: String?,
    val sessionTime: String?,
    val sessionMeridiem: String?,
    val raceSchedule: RaceSchedules.Schedule?,
    val isLoading: Boolean,
    val error: String?,
) : BaseUiState