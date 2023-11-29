package com.aa.ui.screens.phase_1.IntroScreen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aa.ui.navigation.TinyStepsDestination

private const val ROUTE = TinyStepsDestination.IntroScreen


fun NavController.navigateToIntroScreen() {
    navigate(com.aa.ui.screens.phase_1.IntroScreen.ROUTE)
}

fun NavGraphBuilder.introScreen(navController: NavHostController) {
    composable(com.aa.ui.screens.phase_1.IntroScreen.ROUTE) {
        com.aa.ui.screens.phase_1.IntroScreen.IntroScreen(
            navController
        )
    }
}


