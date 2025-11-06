package com.arjesh.boxboxassignment.ui.home.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.arjesh.boxboxassignment.R
import com.arjesh.boxboxassignment.theme.HomeCardCornerRadiusSmall
import com.arjesh.boxboxassignment.theme.RaceKmCardBG

@Composable
fun RaceKMCard(
    modifier: Modifier
) {
    HomeCard(
        modifier = modifier,
        background = RaceKmCardBG,
        cornerRadius = HomeCardCornerRadiusSmall,
        progress = 0.2f,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_race_track),
                contentDescription = null
            )
            Text(text = buildAnnotatedString {
                withStyle(
                    SpanStyle(
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("7015.3")
                }
                withStyle(
                    SpanStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("km")
                }
            })
        }
    }
}