package com.aa.ui.screens.phase_1.discover_screen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aa.ui.navigation.TinyStepsDestination

private const val ROUTE = TinyStepsDestination.Discover


fun NavController.navigateToDiscoverScreen() {
    navigate(ROUTE)
}

fun NavController.backToDiscoverScreen() {
    popBackStack()
}

fun NavGraphBuilder.discoverScreen(navController: NavHostController) {
    composable(ROUTE) { DiscoverScreen(navController) }
}