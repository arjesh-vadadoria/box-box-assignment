package com.arjesh.boxboxassignment.domain.repository.race

import com.arjesh.boxboxassignment.data.model.RaceSchedules
import com.arjesh.boxboxassignment.domain.util.ApiResult
import kotlinx.coroutines.flow.Flow

interface RaceRepository {
    suspend fun getRaceSchedule(): Flow<ApiResult<RaceSchedules>>
}