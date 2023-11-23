package com.aa.ui.screens.infant_home_screen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.aa.ui.navigation.TinyStepsDestination

private const val ROUTE = TinyStepsDestination.InfantHomeScreen

fun NavController.navigateToInfantHomeScreen() {
    navigate(ROUTE)
}

fun NavController.backToInfantHomeScreen() {
    popBackStack()
}

fun NavGraphBuilder.infantHomeScreen(navController: NavController){
    composable(ROUTE){ InfantHomeScreen(navController = navController) }
}