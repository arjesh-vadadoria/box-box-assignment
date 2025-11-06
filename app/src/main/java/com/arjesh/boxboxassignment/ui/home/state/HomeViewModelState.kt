package com.arjesh.boxboxassignment.ui.home.state

import com.arjesh.boxboxassignment.base.BaseUiState
import com.arjesh.boxboxassignment.base.BaseViewModelState
import com.arjesh.boxboxassignment.data.model.Drivers
import com.arjesh.boxboxassignment.data.model.RaceSchedules

data class HomeViewModelState(
    val firstPositionDriver: Drivers.Driver? = null,
    val sessionName: String? = null,
    val sessionDate: String? = null,
    val sessionTime: String? = null,
    val sessionMeridiem: String? = null,
    val raceSchedule: RaceSchedules.Schedule? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
) : BaseViewModelState {
    override fun toUiState(): BaseUiState {
        return HomeUiState(
            firstPositionDriver = firstPositionDriver,
            sessionName = sessionName,
            sessionDate = sessionDate,
            sessionTime = sessionTime,
            sessionMeridiem = sessionMeridiem,
            raceSchedule = raceSchedule,
            isLoading = isLoading,
            error = error,
        )
    }
}
