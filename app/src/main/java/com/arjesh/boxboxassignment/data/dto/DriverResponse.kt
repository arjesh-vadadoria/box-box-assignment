package com.arjesh.boxboxassignment.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class DriversResponse(val drivers: List<DriverResponse>) {
    @Serializable
    data class DriverResponse(
        val driverId: String,
        val podiums: Int,
        val points: String,
        val poles: Int,
        val position: Int,
        val teamId: String,
        val wins: String,
        val firstName: String,
        val lastName: String,
        val driverCode: String,
        val teamName: String,
        val racingNumber: Int
    )
}

