package com.arjesh.boxboxassignment.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class RaceSchedulesResponse(
    val schedule: List<ScheduleResponse>,
) {
    @Serializable
    data class ScheduleResponse(
        val raceId: String,
        val circuitId: String,
        val isSprint: Boolean,
        val raceEndTime: Long,
        val raceName: String,
        val raceStartTime: Long,
        val raceState: String,
        val round: Int,
        val sessions: List<SessionResponse>,
        val podium: List<String>? = null,
    ) {
        @Serializable
        data class SessionResponse(
            val sessionId: String,
            val sessionType: String,
            val sessionName: String,
            val startTime: Long,
            val endTime: Long,
            val sessionState: String,
            val _id: String,
        )
    }
}
