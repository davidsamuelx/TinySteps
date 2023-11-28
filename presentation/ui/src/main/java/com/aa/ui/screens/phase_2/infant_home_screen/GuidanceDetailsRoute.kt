package com.aa.ui.screens.phase_2.infant_home_screen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.aa.ui.navigation.TinyStepsDestination
import com.aa.viewmodels.guidance_details.GuidanceDetailsArgs

private const val ROUTE = TinyStepsDestination.GuidanceDetailsScreen

fun NavGraphBuilder.guidanceDetailsRoute(navController: NavHostController){
    composable(
        route = "$ROUTE/{${GuidanceDetailsArgs.ID_ARG}}",
        arguments = listOf(
            navArgument(GuidanceDetailsArgs.ID_ARG){NavType.IntType}
        )
    ){ GuidanceDetailsScreen(navController = navController)}
}

fun NavController.navigateToGuidanceDetails(id: Int){
    navigate("$ROUTE/${id}")
}