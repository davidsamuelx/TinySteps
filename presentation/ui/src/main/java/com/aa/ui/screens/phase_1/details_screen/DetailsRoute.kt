package com.aa.ui.screens.phase_1.details_screen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.aa.ui.navigation.TinyStepsDestination
import com.aa.viewmodels.baby_details_screen.BabyDetailsArgs

private const val ROUTE = TinyStepsDestination.BabyDetails

fun NavController.navigateToBabyDetailsScreen(id:Int) {
    navigate("$ROUTE/${id}")
}

fun NavGraphBuilder.babyDetailsRoute(navController: NavHostController) {
    composable(
        route ="$ROUTE/{${BabyDetailsArgs.ID}}",
        arguments = listOf(
            navArgument(BabyDetailsArgs.ID) { NavType.IntType },
        )
    ) { BabyDetailsScreen(navController = navController) }
}


