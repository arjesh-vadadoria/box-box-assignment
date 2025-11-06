package com.arjesh.boxboxassignment.ui.home

import androidx.lifecycle.viewModelScope
import com.arjesh.boxboxassignment.base.BaseViewModel
import com.arjesh.boxboxassignment.data.model.RaceSchedules
import com.arjesh.boxboxassignment.domain.repository.driver.DriverRepository
import com.arjesh.boxboxassignment.domain.repository.race.RaceRepository
import com.arjesh.boxboxassignment.domain.usecase.GetUpcomingRaceSessionUseCase
import com.arjesh.boxboxassignment.domain.usecase.GetUpcomingRaceUseCase
import com.arjesh.boxboxassignment.domain.util.ApiResult
import com.arjesh.boxboxassignment.ui.home.state.HomeEffect
import com.arjesh.boxboxassignment.ui.home.state.HomeUiState
import com.arjesh.boxboxassignment.ui.home.state.HomeViewModelState
import com.arjesh.boxboxassignment.utils.getDisplayDate
import com.arjesh.boxboxassignment.utils.getDisplayTime
import com.arjesh.boxboxassignment.utils.getTimeMeridiem
import com.arjesh.boxboxassignment.utils.toMinimumDigit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(
    private val driverRepository: DriverRepository,
    private val raceRepository: RaceRepository,
    private val getUpcomingRaceUseCase: GetUpcomingRaceUseCase,
    private val getUpcomingRaceSessionUseCase: GetUpcomingRaceSessionUseCase,
) : BaseViewModel<HomeViewModelState, HomeUiState, HomeEffect>(initialState = HomeViewModelState()) {

    init {
        getFirstPositionDriver()
        getRaceSchedules()
    }

    fun getFirstPositionDriver() {
        viewModelScope.launch(Dispatchers.IO) {
            driverRepository.getDrivers().collect { result ->
                when (result) {
                    is ApiResult.Loading -> {
                        viewModelState.value = viewModelState.value.copy(isLoading = true)
                    }

                    is ApiResult.Success -> {
                        viewModelState.value = viewModelState.value.copy(
                            firstPositionDriver = result.data.drivers.find { it.position == 1 }?.let {
                                it.copy(
                                    points = it.points.toMinimumDigit(2),
                                    wins = it.wins.toMinimumDigit(2),
                                )
                            },
                            isLoading = false,
                            error = null,
                        )
                    }

                    is ApiResult.Error -> {
                        viewModelState.value = viewModelState.value.copy(
                            isLoading = false,
                            error = result.message
                        )
                    }
                }
            }
        }
    }

    fun getRaceSchedules() {
        viewModelScope.launch(Dispatchers.IO) {
            raceRepository.getRaceSchedule().collect { result ->
                getUpcomingRace(result)
            }
        }
    }

    private fun getUpcomingRace(result: ApiResult<RaceSchedules>) {
        when (val nextRace = getUpcomingRaceUseCase(result)) {
            ApiResult.Loading -> viewModelState.value = viewModelState.value.copy(isLoading = true)
            is ApiResult.Success -> {
                viewModelState.value = viewModelState.value.copy(
                    raceSchedule = nextRace.data,
                    isLoading = false,
                    error = null
                )
                getUpcomingRaceSession(nextRace)
            }

            is ApiResult.Error -> {
                viewModelState.value = viewModelState.value.copy(
                    isLoading = false,
                    error = nextRace.message
                )
            }
        }
    }

    private fun getUpcomingRaceSession(nextRace: ApiResult.Success<RaceSchedules.Schedule?>) {
        when (val nextRaceSession = getUpcomingRaceSessionUseCase(nextRace)) {
            ApiResult.Loading -> viewModelState.value = viewModelState.value.copy(isLoading = true)
            is ApiResult.Success -> viewModelState.value = viewModelState.value.copy(
                sessionName = nextRaceSession.data?.sessionName,
                sessionDate = nextRaceSession.data?.startTime?.getDisplayDate(),
                sessionTime = nextRaceSession.data?.startTime?.getDisplayTime(),
                sessionMeridiem = nextRaceSession.data?.startTime?.getTimeMeridiem(),
                isLoading = false,
                error = null
            )

            is ApiResult.Error -> {
                viewModelState.value = viewModelState.value.copy(
                    isLoading = false,
                    error = nextRaceSession.message
                )
            }
        }
    }
}