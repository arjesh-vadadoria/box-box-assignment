package com.arjesh.boxboxassignment.domain.usecase

import com.arjesh.boxboxassignment.data.model.RaceSchedules
import com.arjesh.boxboxassignment.domain.RaceState
import com.arjesh.boxboxassignment.domain.util.ApiResult
import com.arjesh.boxboxassignment.utils.toInstant
import java.time.Instant

class GetUpcomingRaceSessionUseCase {
    operator fun invoke(result: ApiResult<RaceSchedules.Schedule?>): ApiResult<RaceSchedules.Schedule.Session?> {
        return when (result) {
            is ApiResult.Success -> {
                val now = Instant.now()

                //session shouldn't be started -> current time should be less then start time
                //session shouldn't be ended -> current time should be less then end time
                //session start time should be in nearest future -> minimum start time from above results
                val nextRaceSession = result.data?.sessions
                    ?.filter { session ->
                        now < session.startTime.toInstant()
                                && now < session.endTime.toInstant()
                                && RaceState.valueOf(session.sessionState) == RaceState.upcoming // added extra check on session state since we are getting it in the response
                    }?.minByOrNull { it.startTime }

                ApiResult.Success(nextRaceSession)
            }

            is ApiResult.Error -> ApiResult.Error(result.exception, result.message)
            is ApiResult.Loading -> ApiResult.Loading
        }
    }
}