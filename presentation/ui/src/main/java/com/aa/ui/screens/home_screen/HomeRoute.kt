package com.aa.ui.screens.home_screen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aa.ui.navigation.TinyStepsDestination

private const val ROUTE = TinyStepsDestination.Home


fun NavController.navigateToHomeScreen() {
    navigate(ROUTE)
}

fun NavController.backToHomeScreen() {
    popBackStack()
}

fun NavGraphBuilder.homeScreen(navController: NavHostController) {
    composable(ROUTE) { HomeScreen(navController) }
}