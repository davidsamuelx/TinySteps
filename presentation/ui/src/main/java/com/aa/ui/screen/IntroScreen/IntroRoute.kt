package com.aa.ui.screen.IntroScreen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aa.ui.navigation.TinyStepsDestination

private const val ROUTE = TinyStepsDestination.IntroScreen


fun NavController.navigateToIntroScreen() {
    navigate(ROUTE)
}

fun NavGraphBuilder.introScreen(navController: NavHostController) {
    composable(ROUTE) { IntroScreen(navController) }
}


