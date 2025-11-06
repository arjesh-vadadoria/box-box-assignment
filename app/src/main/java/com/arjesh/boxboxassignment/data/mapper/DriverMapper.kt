package com.arjesh.boxboxassignment.data.mapper

import com.arjesh.boxboxassignment.data.dto.DriversResponse
import com.arjesh.boxboxassignment.data.model.Drivers

fun DriversResponse.toDomain() = Drivers(
    drivers = drivers.toDomain()
)

fun List<DriversResponse.DriverResponse>.toDomain() =
    this.map { response ->
        Drivers.Driver(
            points = response.points,
            position = response.position,
            wins = response.wins,
            firstName = response.firstName,
        )
    }

