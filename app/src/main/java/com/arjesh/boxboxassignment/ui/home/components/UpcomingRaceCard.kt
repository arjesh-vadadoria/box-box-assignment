package com.arjesh.boxboxassignment.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arjesh.boxboxassignment.R
import com.arjesh.boxboxassignment.theme.UpcomingRaceCardBG
import com.arjesh.boxboxassignment.theme.UpcomingRaceTime

@Composable
fun UpcomingRaceCard(
    modifier: Modifier = Modifier,
    sessionName: String,
    sessionDate: String,
    sessionTime: String,
    sessionMeridiem: String,
    onClick: () -> Unit,
) {
    HomeCard(
        modifier = modifier,
        background = UpcomingRaceCardBG,
        onClick = {
            onClick()
        }
    ) {
        Column(
            modifier = Modifier.align(Alignment.BottomStart)
        ) {
            Text(
                text = sessionName,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_calender),
                    tint = Color.White,
                    modifier = Modifier.size(16.dp),
                    contentDescription = null,
                )
                Spacer(Modifier.width(5.dp))
                Text(
                    text = sessionDate,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                )
            }
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        SpanStyle(
                            fontSize = 36.sp,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append(sessionTime)
                    }
                    withStyle(
                        SpanStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append(sessionMeridiem)
                    }
                },
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = UpcomingRaceTime,
            )
        }
        Image(
            painter = painterResource(R.drawable.img_circuit),
            modifier = Modifier
                .size(48.dp)
                .align(Alignment.TopEnd),
            contentDescription = null,
        )
    }
}

