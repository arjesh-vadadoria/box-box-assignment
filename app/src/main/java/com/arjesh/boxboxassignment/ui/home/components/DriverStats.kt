package com.arjesh.boxboxassignment.ui.home.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arjesh.boxboxassignment.theme.DriverIconTint

@Composable
fun DriverStats(
    @DrawableRes iconRes: Int,
    title: String,
    value: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.Bottom
    ) {
        Icon(
            painter = painterResource(iconRes),
            tint = DriverIconTint,
            modifier = Modifier
                .size(18.dp)
                .align(Alignment.CenterVertically),
            contentDescription = "driver_stat_icon",
        )
        Text(
            text = value,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .padding(horizontal = 3.dp)
                .alignByBaseline(),
        )
        Text(
            text = title,
            fontSize = 10.sp,
            color = Color.White,
            modifier = Modifier.alignByBaseline(),
        )
    }
}
