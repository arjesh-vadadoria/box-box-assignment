package com.arjesh.boxboxassignment.ui.home.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arjesh.boxboxassignment.theme.IndicatorActive
import com.arjesh.boxboxassignment.theme.IndicatorInActive

@Composable
fun PagerIndicator(
    modifier: Modifier = Modifier,
    pagerState: PagerState
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        repeat(pagerState.pageCount) { index ->
            val selected = pagerState.currentPage == index
            val indicatorWidth by animateDpAsState(
                targetValue = if (selected) 24.dp else 5.dp,
            )
            Box(
                modifier = Modifier
                    .width(indicatorWidth)
                    .height(5.dp)
                    .background(
                        if (selected) IndicatorActive else IndicatorInActive,
                        shape = RoundedCornerShape(50)
                    )
            )
        }
    }
}
