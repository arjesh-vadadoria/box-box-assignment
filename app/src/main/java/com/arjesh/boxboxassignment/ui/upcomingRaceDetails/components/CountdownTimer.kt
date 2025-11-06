package com.arjesh.boxboxassignment.ui.upcomingRaceDetails.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.arjesh.boxboxassignment.R
import com.arjesh.boxboxassignment.utils.calculateTimeRemaining
import kotlinx.coroutines.delay

@Composable
fun CountdownTimer(
    targetTimeInSeconds: Long,
    modifier: Modifier = Modifier,
) {
    var timeRemaining by remember { mutableStateOf(calculateTimeRemaining(targetTimeInSeconds)) }

    LaunchedEffect(targetTimeInSeconds) {
        while (true) {
            timeRemaining = calculateTimeRemaining(targetTimeInSeconds)
            delay(1000)

            if (timeRemaining.days == 0L &&
                timeRemaining.hours == 0L &&
                timeRemaining.minutes == 0L &&
                timeRemaining.seconds == 0L
            ) {
                break
            }
        }
    }

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(18.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TimeUnit(
            value = timeRemaining.days,
            label = stringResource(R.string.days),
        )

        TimeUnit(
            value = timeRemaining.hours,
            label = stringResource(R.string.hours),
        )

        TimeUnit(
            value = timeRemaining.minutes,
            label = stringResource(R.string.minutes),
        )
    }
}