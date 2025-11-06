package com.arjesh.boxboxassignment.ui.upcomingRaceDetails.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.arjesh.boxboxassignment.theme.GothamFonts
import com.arjesh.boxboxassignment.theme.MonteserratFonts
import com.arjesh.boxboxassignment.theme.UpcomingCountDownTextColor
import com.arjesh.boxboxassignment.utils.toMinimumDigit

@Composable
fun TimeUnit(
    value: Long,
    label: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = value.toString().toMinimumDigit(2),
            fontSize = 28.sp,
            fontFamily = MonteserratFonts,
            fontWeight = FontWeight.Medium,
            color = UpcomingCountDownTextColor,
        )

        Text(
            text = label,
            fontSize = 11.sp,
            fontFamily = GothamFonts,
            color = Color.White,
            fontWeight = FontWeight.Medium
        )
    }
}