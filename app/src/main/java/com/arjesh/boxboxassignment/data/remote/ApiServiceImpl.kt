package com.arjesh.boxboxassignment.data.remote

import com.arjesh.boxboxassignment.data.dto.DriversResponse
import com.arjesh.boxboxassignment.data.dto.RaceSchedulesResponse
import com.arjesh.boxboxassignment.utils.API_VERSION
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ApiServiceImpl(
    private val client: HttpClient
) : ApiService {
    override suspend fun getDrivers(): DriversResponse {
        return client.get("${API_VERSION}/e8616da8-220c-4aab-a670-ab2d43224ecb").body()
    }

    override suspend fun getRaceSchedules(): RaceSchedulesResponse {
        return client.get("${API_VERSION}/9086a3f1-f02b-4d24-8dd3-b63582f45e67").body()
    }
}