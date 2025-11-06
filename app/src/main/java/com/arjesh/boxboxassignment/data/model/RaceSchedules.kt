package com.arjesh.boxboxassignment.data.model

import kotlinx.serialization.Serializable

@Serializable
data class RaceSchedules(
    val schedule: List<Schedule>,
) {
    @Serializable
    data class Schedule(
        val raceId: String,
        val circuitId: String,
        val raceEndTime: Long,
        val raceName: String,
        val raceStartTime: Long,
        val raceState: String,
        val round: Int,
        val displayStartEndTime: String? = null,
        val sessions: List<Session>,
    ) {
        @Serializable
        data class Session(
            val sessionName: String,
            val startTime: Long,
            val endTime: Long,
            val sessionState: String,
        )
    }
}
