package com.arjesh.boxboxassignment.domain.repository.race

import com.arjesh.boxboxassignment.data.mapper.toDomain
import com.arjesh.boxboxassignment.data.model.RaceSchedules
import com.arjesh.boxboxassignment.data.remote.ApiService
import com.arjesh.boxboxassignment.domain.util.ApiResult
import com.arjesh.boxboxassignment.domain.util.ErrorMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RaceRepositoryImpl(
    val apiService: ApiService
) : RaceRepository {
    override suspend fun getRaceSchedule(): Flow<ApiResult<RaceSchedules>> = flow {
        emit(ApiResult.Loading)
        runCatching {
            val schedules = apiService.getRaceSchedules().toDomain()
            emit(ApiResult.Success(schedules))
        }.onFailure {
            val networkException = ErrorMapper.mapException(it)
            emit(ApiResult.Error(networkException, networkException.message))
        }
    }
}