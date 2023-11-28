package com.aa.ui.screens.phase_2.infant_exercise

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.aa.ui.navigation.TinyStepsDestination
import com.aa.viewmodels.infant_exercise.InfantExerciseDetailsArgs

private const val ROUTE = TinyStepsDestination.InfantExerciseDetailsScreen

fun NavGraphBuilder.infantExerciseDetailsRoute(navController: NavHostController){
    composable(
        "$ROUTE/{${InfantExerciseDetailsArgs.ID_ARG}}",
        arguments = listOf(
            navArgument(InfantExerciseDetailsArgs.ID_ARG){
                type = NavType.IntType
            }
        )
    ){ InfantExerciseDetailScreen(navController) }
}

fun NavController.navigateToInfantExerciseDetails(id: Int){
    navigate("${ROUTE}/$id")
}