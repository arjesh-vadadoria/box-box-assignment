package com.arjesh.boxboxassignment.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.arjesh.boxboxassignment.R
import com.arjesh.boxboxassignment.theme.DarkBG
import com.arjesh.boxboxassignment.theme.HomeCardRowHeight
import com.arjesh.boxboxassignment.theme.ListElementPadding
import com.arjesh.boxboxassignment.theme.RootScreenPadding
import com.arjesh.boxboxassignment.ui.common.BoxWithLoader
import com.arjesh.boxboxassignment.ui.home.components.EducationCard
import com.arjesh.boxboxassignment.ui.home.components.GetPro
import com.arjesh.boxboxassignment.ui.home.components.HomeImageCard
import com.arjesh.boxboxassignment.ui.home.components.HomeTopSlider
import com.arjesh.boxboxassignment.ui.home.components.RaceKMCard
import com.arjesh.boxboxassignment.ui.home.components.UpcomingRaceCard
import com.arjesh.boxboxassignment.ui.navigation.Route
import com.arjesh.boxboxassignment.utils.INSTA_LINK
import com.arjesh.boxboxassignment.utils.MEDIUM_PAGE_LINK
import com.arjesh.boxboxassignment.utils.openCustomTab
import com.arjesh.boxboxassignment.utils.showToast
import kotlinx.coroutines.delay
import kotlinx.serialization.json.Json
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    onNavigate: (Route) -> Unit
) {
    val viewModel = koinViewModel<HomeViewModel>()
    val pagerState = rememberPagerState(pageCount = { HomePagerPageType.entries.size })
    val context = LocalContext.current
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        while (true) {
            delay(3000)
            val next = (pagerState.currentPage + 1) % pagerState.pageCount
            pagerState.animateScrollToPage(next)
        }
    }

    val listState = rememberLazyListState()
    val showHeaderBackground by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex > 0 ||
                    listState.firstVisibleItemScrollOffset > 0
        }
    }

    BoxWithLoader(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBG),
        isLoading = state.isLoading,
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            state = listState,
            verticalArrangement = Arrangement.spacedBy(ListElementPadding),
        ) {
            item {
                HomeTopSlider(
                    pagerState = pagerState,
                    modifier = Modifier.fillMaxSize(),
                    driverName = state.firstPositionDriver?.firstName ?: stringResource(R.string.driver),
                    wins = state.firstPositionDriver?.wins ?: stringResource(R.string._00),
                    points = state.firstPositionDriver?.points ?: stringResource(R.string._00),
                )
            }

            item {
                Row(
                    modifier = Modifier
                        .padding(horizontal = RootScreenPadding)
                        .height(HomeCardRowHeight),
                    horizontalArrangement = Arrangement.spacedBy(ListElementPadding)
                ) {
                    UpcomingRaceCard(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f),
                        sessionName = state.sessionName ?: stringResource(R.string.fp1),
                        sessionDate = state.sessionDate ?: stringResource(R.string.no_session),
                        sessionTime = state.sessionTime ?: stringResource(R.string._00_00),
                        sessionMeridiem = state.sessionMeridiem ?: stringResource(R.string.am),
                        onClick = {
                            state.raceSchedule?.let {
                                val json = Json.encodeToString(it)
                                onNavigate(Route.UpcomingRaceDetails(json))
                            } ?: showToast(context, context.getString(R.string.no_upcoming_race_available))
                        },
                    )
                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(ListElementPadding)
                    ) {
                        RaceKMCard(
                            modifier = Modifier.weight(1f)
                        )
                        EducationCard(
                            modifier = Modifier.weight(1f),
                            onClick = {
                                openCustomTab(context, MEDIUM_PAGE_LINK)
                            })
                    }
                }
            }

            item {
                HomeImageCard(
                    modifier = Modifier
                        .padding(horizontal = RootScreenPadding)
                        .navigationBarsPadding(),
                    onClick = {
                        openCustomTab(context, INSTA_LINK)
                    }
                )
            }
        }
        GetPro(
            modifier = Modifier.align(Alignment.TopCenter),
            showBackground = showHeaderBackground,
        )
    }
}
