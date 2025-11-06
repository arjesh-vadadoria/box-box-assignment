package com.arjesh.boxboxassignment.data.remote

import com.arjesh.boxboxassignment.data.dto.DriversResponse
import com.arjesh.boxboxassignment.data.dto.RaceSchedulesResponse

interface ApiService {
    suspend fun getDrivers(): DriversResponse
    suspend fun getRaceSchedules(): RaceSchedulesResponse
}