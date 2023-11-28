package com.aa.ui.screens.phase_2.infant_home_screen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aa.ui.navigation.TinyStepsDestination

private const val ROUTE = TinyStepsDestination.InfantHomeScreen

fun NavController.navigateToInfantHomeScreen() {
    navigate(ROUTE)
}

fun NavController.backToInfantHomeScreen() {
    popBackStack()
}

fun NavGraphBuilder.infantHomeScreen(navController: NavHostController){
    composable(ROUTE){ InfantHomeScreen(navController = navController) }
}