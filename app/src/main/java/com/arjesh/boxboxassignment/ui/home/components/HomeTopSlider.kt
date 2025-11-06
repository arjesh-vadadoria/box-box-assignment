package com.arjesh.boxboxassignment.ui.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.arjesh.boxboxassignment.theme.DriverPointsGradientEnd
import com.arjesh.boxboxassignment.theme.HorizontalPageHeight
import com.arjesh.boxboxassignment.ui.home.HomePagerPageType
import com.arjesh.boxboxassignment.utils.INSTA_LINK
import com.arjesh.boxboxassignment.utils.openCustomTab


@Composable
fun HomeTopSlider(
    pagerState: PagerState,
    modifier: Modifier,
    driverName: String,
    wins: String,
    points: String, // not adding setting position dynamically since we are showing first position driver only
) {
    val context = LocalContext.current
    Box(
        modifier = modifier,
        contentAlignment = Alignment.BottomCenter,
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth(),
        ) { page ->
            when (HomePagerPageType.fromIndex(page)) {
                HomePagerPageType.WinnerDriver -> {
                    HomeWinnerDriverPage(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(HorizontalPageHeight)
                            .background(color = DriverPointsGradientEnd)
                            .clipToBounds(),
                        driverName = driverName,
                        wins = wins,
                        points = points,
                    )
                }

                HomePagerPageType.CommunityPage -> {
                    HomeCommunityPage(
                        modifier = Modifier.size(
                            HorizontalPageHeight
                        ),
                        onFollowButtonClick = {
                            openCustomTab(context, INSTA_LINK)
                        }
                    )
                }
            }
        }
        PagerIndicator(
            modifier = Modifier.padding(vertical = 20.dp),
            pagerState = pagerState,
        )
    }
}

