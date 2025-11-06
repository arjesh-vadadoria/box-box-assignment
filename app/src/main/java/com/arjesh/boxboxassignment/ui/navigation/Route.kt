package com.arjesh.boxboxassignment.ui.navigation

import kotlinx.serialization.Serializable

sealed class Route {

    @Serializable
    object Back : Route()

    @Serializable
    object Home : Route()

    @Serializable
    object Calender : Route()

    @Serializable
    object Leaderboard : Route()

    @Serializable
    object Explore : Route()

    @Serializable
    object Profile : Route()

    @Serializable
    data class UpcomingRaceDetails(
        val raceSchedule: String,
    ) : Route()

}
