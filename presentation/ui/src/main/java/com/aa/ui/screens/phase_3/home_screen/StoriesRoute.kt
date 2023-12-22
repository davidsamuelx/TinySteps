package com.aa.ui.screens.phase_3.home_screen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.aa.ui.navigation.TinyStepsDestination

private const val ROUTE = TinyStepsDestination.HomeKidsScreen

fun NavController.navigateToHomeKidsScreen() {
    navigate(ROUTE)
}

fun NavController.backToHomeKidsScreen() {
    popBackStack()
}

fun NavGraphBuilder.homeKidsRoute(navController: NavController){
    composable(ROUTE){ KidsHomeScreen(navController = navController) }
}