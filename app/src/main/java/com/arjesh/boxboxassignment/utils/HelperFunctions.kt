package com.arjesh.boxboxassignment.utils

import android.content.Context
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.net.toUri
import com.arjesh.boxboxassignment.data.model.TimeRemaining
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import kotlin.math.max

fun showToast(context: Context, message: String) = Toast.makeText(context, message, Toast.LENGTH_SHORT).show()

fun openCustomTab(context: Context, url: String) {
    val customTabsIntent = CustomTabsIntent.Builder()
        .setShowTitle(true)
        .setColorScheme(CustomTabsIntent.COLOR_SCHEME_SYSTEM)
        .build()

    customTabsIntent.launchUrl(context, url.toUri())
}

fun Int.toMinimumDigit(minDigits: Int): String = String.format("%0${minDigits}d", this)
fun String.toMinimumDigit(minDigits: Int): String = this.padStart(minDigits, '0')

//date & time
fun Long.toInstant() = Instant.ofEpochSecond(this)

fun Long.getDisplayDate(): String? {
    val timeFormatter = DateTimeFormatter.ofPattern(UPCOMING_SESSION_DISPLAY_DATE)
    return Instant.ofEpochSecond(this)
        .atZone(ZoneId.systemDefault())
        .format(timeFormatter)
}

fun Long.getDisplayTime(): String? {
    val timeFormatter = DateTimeFormatter.ofPattern(UPCOMING_SESSION_DISPLAY_TIME)
    return Instant.ofEpochSecond(this)
        .atZone(ZoneId.systemDefault())
        .format(timeFormatter)
}

fun Long.getTimeMeridiem(): String? {
    val timeFormatter = DateTimeFormatter.ofPattern(TIME_MERIDIEM)
    return Instant.ofEpochSecond(this)
        .atZone(ZoneId.systemDefault())
        .format(timeFormatter)
}

fun getDisplayRaceStartEndTime(startSec: Long, endSec: Long): String {
    val zone = ZoneId.systemDefault()

    val start = Instant.ofEpochSecond(startSec).atZone(zone)
    val end = Instant.ofEpochSecond(endSec).atZone(zone)

    val startDay = start.format(DateTimeFormatter.ofPattern("dd"))
    val endDayMonth = end.format(DateTimeFormatter.ofPattern("dd MMMM"))

    return "$startDay - $endDayMonth"
}

fun calculateTimeRemaining(targetTimeInSeconds: Long): TimeRemaining {
    val currentTimeInSeconds = System.currentTimeMillis() / 1000
    val remainingSeconds = max(0, targetTimeInSeconds - currentTimeInSeconds)

    val days = remainingSeconds / 86400
    val hours = (remainingSeconds % 86400) / 3600
    val minutes = (remainingSeconds % 3600) / 60
    val seconds = remainingSeconds % 60

    return TimeRemaining(
        days = days,
        hours = hours,
        minutes = minutes,
        seconds = seconds
    )
}


