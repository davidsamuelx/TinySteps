package com.aa.ui.screens.phase_2.infant_discover_screen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aa.ui.navigation.TinyStepsDestination

private const val ROUTE = TinyStepsDestination.InfantDiscoverScreen

fun NavController.navigateToInfantDiscoverScreen() {
    navigate(com.aa.ui.screens.phase_2.infant_discover_screen.ROUTE)
}

fun NavController.backToInfantDiscoverScreen(){
    popBackStack()
}

fun NavGraphBuilder.infantDiscoverRoute(navController: NavHostController){
    composable(com.aa.ui.screens.phase_2.infant_discover_screen.ROUTE){
        com.aa.ui.screens.phase_2.infant_discover_screen.InfantDiscoverScreen(
            navController = navController
        )
    }
}