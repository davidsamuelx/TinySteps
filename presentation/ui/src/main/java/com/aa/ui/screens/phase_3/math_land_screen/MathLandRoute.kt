package com.aa.ui.screens.phase_3.math_land_screen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.aa.ui.navigation.TinyStepsDestination

private const val ROUTE = TinyStepsDestination.MathLandScreen

fun NavController.navigateToMathLandScreen() {
    navigate(ROUTE)
}

fun NavGraphBuilder.mathLandRoute(navController: NavController){
    composable(ROUTE){ MathLandScreen(navController = navController) }
}