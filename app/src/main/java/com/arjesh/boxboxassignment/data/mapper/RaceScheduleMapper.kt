package com.arjesh.boxboxassignment.data.mapper

import com.arjesh.boxboxassignment.data.dto.RaceSchedulesResponse
import com.arjesh.boxboxassignment.data.model.RaceSchedules

fun RaceSchedulesResponse.toDomain() = RaceSchedules(
    schedule = schedule.toScheduleDomain()
)

private fun List<RaceSchedulesResponse.ScheduleResponse>.toScheduleDomain() =
    this.map { response ->
        RaceSchedules.Schedule(
            raceId = response.raceId,
            circuitId = response.circuitId,
            raceEndTime = response.raceEndTime,
            raceName = response.raceName,
            raceStartTime = response.raceStartTime,
            raceState = response.raceState,
            round = response.round,
            sessions = response.sessions.toSessionDomain(),
        )
    }

private fun List<RaceSchedulesResponse.ScheduleResponse.SessionResponse>.toSessionDomain() =
    this.map { response ->
        RaceSchedules.Schedule.Session(
            sessionName = response.sessionName,
            startTime = response.startTime,
            endTime = response.endTime,
            sessionState = response.sessionState,
        )
    }

