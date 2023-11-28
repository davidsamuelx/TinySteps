package com.aa.ui.screens.phase_2.relation_screen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.aa.ui.navigation.TinyStepsDestination
import com.aa.viewmodels.relation_details.RelationDetailsArgs

private const val ROUTE = TinyStepsDestination.RelationDetailsScreen

fun NavGraphBuilder.relationDetailsRoute(navController: NavHostController){
    composable(
        route = "$ROUTE/{${RelationDetailsArgs.ID_ARG}}",
        arguments = listOf(
            navArgument(RelationDetailsArgs.ID_ARG){NavType.IntType}
        )
    ){ RelationDetailsScreen(navController = navController) }
}

fun NavController.navigateToRelationDetails(id: Int){
    navigate("$ROUTE/${id}")
}

