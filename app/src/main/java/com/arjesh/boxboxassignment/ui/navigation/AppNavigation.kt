package com.arjesh.boxboxassignment.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.arjesh.boxboxassignment.R
import com.arjesh.boxboxassignment.ui.home.HomeScreen
import com.arjesh.boxboxassignment.ui.upcomingRaceDetails.UpcomingRaceDetailsScreen


@Composable
fun AppNavigation() {
    val navItems = listOf(
        BottomNavItem(R.drawable.ic_home_nav, Route.Home),
        BottomNavItem(R.drawable.ic_calendar_nav, Route.Calender),
        BottomNavItem(R.drawable.ic_trophy_nav, Route.Leaderboard),
        BottomNavItem(R.drawable.ic_globe_nav, Route.Explore),
        BottomNavItem(R.drawable.ic_profile_nav, Route.Profile),
    )
    val navController = rememberNavController()
    val currentRoute =
        navController.currentBackStackEntryFlow.collectAsState(initial = navController.currentBackStackEntry)
            .value

    val showBottomBar = currentRoute == Route.Home
    var selectedIndex by remember { mutableStateOf(0) }

    fun navigate(route: Route) {
        when (route) {
            Route.Back -> navController.navigateUp()
            else -> navController.navigate(route = route)
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomBar(
                items = navItems,
                selectedIndex = selectedIndex,
                onItemSelected = {
                    selectedIndex = it
                    navController.navigate(navItems[selectedIndex].route)
                },
            )
        }
    ) { scaffoldPadding ->
        NavHost(
            navController = navController,
            startDestination = Route.Home,
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = scaffoldPadding.calculateBottomPadding()),
        ) {
            composable<Route.Home> {
                HomeScreen(onNavigate = {
                    navigate(it)
                })
            }
            composable<Route.UpcomingRaceDetails> {
                UpcomingRaceDetailsScreen(onNavigate = {
                    navigate(it)
                })
            }

            composable<Route.Calender> {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("Calendar")
                }
            }

            composable<Route.Leaderboard> {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("Leaderboard")
                }
            }

            composable<Route.Explore> {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("Explore")
                }
            }

            composable<Route.Profile> {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("Profile")
                }
            }
        }
    }


}