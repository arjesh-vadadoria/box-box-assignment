package com.arjesh.boxboxassignment.ui.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.arjesh.boxboxassignment.theme.DarkBG
import com.arjesh.boxboxassignment.theme.HomeCardCornerRadiusRegular
import com.arjesh.boxboxassignment.theme.HomeCardStroke


@Composable
fun HomeCard(
    modifier: Modifier = Modifier,
    background: Color,
    cornerRadius: Dp = HomeCardCornerRadiusRegular,
    progress: Float? = null,
    onClick: (() -> Unit)? = null,
    content: @Composable BoxScope.() -> Unit
) {
    progress?.let {
        Card(
            modifier = modifier,
            shape = RoundedCornerShape(cornerRadius),
            border = BorderStroke(width = 1.dp, HomeCardStroke),
            colors = CardDefaults.cardColors().copy(
                disabledContentColor = Color.White
            ),
            enabled = onClick != null,
            onClick = { onClick?.invoke() },
        ) {
            Box {
                LinearProgressIndicator(
                    progress = {
                        progress
                    },
                    modifier = Modifier
                        .fillMaxHeight(),
                    color = background,
                    trackColor = DarkBG,
                    strokeCap = StrokeCap.Square,
                    drawStopIndicator = {},
                )
                Box(
                    Modifier.padding(12.dp)
                ) {
                    content()
                }
            }
        }
    } ?: run {
        Box(
            modifier = modifier
                .clip(RoundedCornerShape(cornerRadius))
                .clickable(
                    enabled = onClick != null,
                    onClick = {
                        onClick?.invoke()
                    })
                .background(background)
                .padding(12.dp),
        ) {
            content()
        }
    }
}

