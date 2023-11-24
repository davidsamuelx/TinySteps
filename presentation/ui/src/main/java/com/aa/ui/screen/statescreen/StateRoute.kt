package com.aa.ui.screen.statescreen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aa.ui.navigation.TinyStepsDestination

private const val ROUTE = TinyStepsDestination.StateScreen


fun NavController.navigateToStateScreen() {
    navigate(ROUTE)
}

fun NavController.backToSignInScreen() {
    popBackStack()
}

fun NavGraphBuilder.state(navController: NavHostController) {
    composable(ROUTE) { StateScreen(navController) }
}


