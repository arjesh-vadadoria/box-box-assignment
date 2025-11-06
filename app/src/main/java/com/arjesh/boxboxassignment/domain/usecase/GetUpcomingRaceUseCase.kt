package com.arjesh.boxboxassignment.domain.usecase

import com.arjesh.boxboxassignment.data.model.RaceSchedules
import com.arjesh.boxboxassignment.domain.RaceState
import com.arjesh.boxboxassignment.domain.util.ApiResult
import com.arjesh.boxboxassignment.utils.toInstant
import java.time.Instant

class GetUpcomingRaceUseCase {
    operator fun invoke(result: ApiResult<RaceSchedules>): ApiResult<RaceSchedules.Schedule?> {
        return when (result) {
            is ApiResult.Success -> {
                val now = Instant.now()

                //race shouldn't be started -> current time should be less then start time
                //race shouldn't be ended -> current time should be less then end time
                //race start time should be in nearest future -> minimum start time from above results
                val nextRace = result.data.schedule
                    .filter { raceSchedule ->
                        now < raceSchedule.raceStartTime.toInstant()
                                && now < raceSchedule.raceEndTime.toInstant()
                                && RaceState.valueOf(raceSchedule.raceState) == RaceState.upcoming // added extra check on race state since we are getting it in the response
                    }
                    .minByOrNull { it.raceStartTime }

                ApiResult.Success(nextRace)
            }

            is ApiResult.Error -> ApiResult.Error(result.exception, result.message)
            is ApiResult.Loading -> ApiResult.Loading
        }
    }
}