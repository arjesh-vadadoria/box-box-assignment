package com.arjesh.boxboxassignment.domain.repository.driver

import com.arjesh.boxboxassignment.data.mapper.toDomain
import com.arjesh.boxboxassignment.data.model.Drivers
import com.arjesh.boxboxassignment.data.remote.ApiService
import com.arjesh.boxboxassignment.domain.util.ApiResult
import com.arjesh.boxboxassignment.domain.util.ErrorMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DriverRepositoryImpl(
    private val apiService: ApiService
) : DriverRepository {

    override suspend fun getDrivers(): Flow<ApiResult<Drivers>> = flow {
        emit(ApiResult.Loading)
        runCatching {
            val drivers = apiService.getDrivers().toDomain()
            emit(ApiResult.Success(drivers))
        }.onFailure {
            val networkException = ErrorMapper.mapException(it)
            emit(ApiResult.Error(networkException, networkException.message))
        }
    }

}