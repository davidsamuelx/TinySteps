package com.aa.ui.screens.phase_3.kids_discover_screen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aa.ui.navigation.TinyStepsDestination

private const val ROUTE = TinyStepsDestination.KidsDiscoverScreen

fun NavController.navigateToKidsDiscoverScreen() {
    navigate(ROUTE)
}

fun NavController.backToKidsDiscoverScreen(){
    popBackStack()
}

fun NavGraphBuilder.kidsDiscoverRoute(navController: NavHostController){
    composable(ROUTE){
        KidsDiscoverScreen(
            navController = navController
        )
    }
}