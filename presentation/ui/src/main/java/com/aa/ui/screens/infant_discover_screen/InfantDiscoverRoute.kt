package com.aa.ui.screens.infant_discover_screen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aa.ui.navigation.TinyStepsDestination

private const val ROUTE = TinyStepsDestination.InfantDiscoverScreen

fun NavController.navigateToInfantDiscoverScreen() {
    navigate(ROUTE)
}

fun NavController.backToInfantDiscoverScreen(){
    popBackStack()
}

fun NavGraphBuilder.infantDiscoverRoute(navController: NavHostController){
    composable(ROUTE){ InfantDiscoverScreen(navController = navController) }
}