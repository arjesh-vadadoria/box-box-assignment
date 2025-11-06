package com.arjesh.boxboxassignment.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arjesh.boxboxassignment.R
import com.arjesh.boxboxassignment.theme.DriverPointsGradientEnd
import com.arjesh.boxboxassignment.theme.DriverPointsGradientStart
import com.arjesh.boxboxassignment.theme.PagerHeaderTextColor
import com.arjesh.boxboxassignment.theme.SpaceGroteskFonts

@Composable
fun HomeWinnerDriverPage(
    modifier: Modifier,
    driverName: String,
    wins: String,
    points: String,
) {
    Box(
        modifier = modifier
            .padding(top = 20.dp)
            .statusBarsPadding()
    ) {
        Text(
            text = driverName,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(x = 30.dp),
            maxLines = 1,
            softWrap = false,
            style = MaterialTheme.typography.displayLarge.copy(
                color = PagerHeaderTextColor,
                fontFamily = SpaceGroteskFonts,
                fontWeight = FontWeight.Bold,
                fontSize = 164.sp,
                letterSpacing = (-10).sp,
            )
        )
        Image(
            painter = painterResource(R.drawable.img_driver),
            modifier = Modifier
                .aspectRatio(1f)
                .align(Alignment.BottomEnd)
                .offset(x = 60.dp),
            contentDescription = "driver_image",
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black.copy(0.7f),
                            Color.Black
                        ),
                        startY = 100f,
                        endY = 500f
                    )
                )
                .align(Alignment.BottomCenter),
        )
        Column(
            modifier = Modifier
                .padding(horizontal = 26.dp, vertical = 36.dp)
                .align(Alignment.BottomStart),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Row {
                DriverStats(
                    iconRes = R.drawable.ic_position,
                    title = stringResource(R.string.pos),
                    value = stringResource(R.string.pos_01)
                )
                Spacer(Modifier.padding(10.dp))
                DriverStats(
                    iconRes = R.drawable.ic_wins,
                    title = stringResource(R.string.wins),
                    value = wins
                )
            }
            Row(
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = points,
                    fontSize = 72.sp,
                    fontWeight = FontWeight.Light,
                    lineHeight = 70.sp,
                    style = MaterialTheme.typography.displayLarge.copy(
                        Brush.verticalGradient(
                            colors = listOf(
                                DriverPointsGradientStart,
                                DriverPointsGradientEnd,
                            ),
                        )
                    ),
                    modifier = Modifier.alignByBaseline()
                )
                Spacer(Modifier.width(10.dp))
                Text(
                    text = stringResource(R.string.pts),
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    lineHeight = 14.sp,
                    modifier = Modifier
                        .background(color = DriverPointsGradientEnd, shape = RoundedCornerShape(6.dp))
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                        .alignByBaseline(),
                )
            }
        }

    }
}
