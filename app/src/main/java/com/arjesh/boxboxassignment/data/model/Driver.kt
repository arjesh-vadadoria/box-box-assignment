package com.arjesh.boxboxassignment.data.model

data class Drivers(val drivers: List<Driver>) {
    data class Driver(
        val points: String,
        val position: Int,
        val wins: String,
        val firstName: String,
    )
}

