package com.arjesh.boxboxassignment.domain.repository.driver

import com.arjesh.boxboxassignment.data.model.Drivers
import com.arjesh.boxboxassignment.domain.util.ApiResult
import kotlinx.coroutines.flow.Flow

interface DriverRepository {
    suspend fun getDrivers(): Flow<ApiResult<Drivers>>
}