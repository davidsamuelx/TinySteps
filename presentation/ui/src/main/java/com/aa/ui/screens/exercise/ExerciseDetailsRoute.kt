package com.aa.ui.screens.exercise

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.aa.viewmodels.exercise.ExerciseDetailsArgs
import com.aa.ui.navigation.TinyStepsDestination

private const val ROUTE = TinyStepsDestination.ExerciseDetailsScreen

@RequiresApi(Build.VERSION_CODES.Q)
fun NavGraphBuilder.exerciseDetailsRoute(navController: NavController) {
    composable(
        "$ROUTE/{${ExerciseDetailsArgs.ID_ARG}}",
        arguments = listOf(
            navArgument(ExerciseDetailsArgs.ID_ARG){
                type = NavType.IntType
            }
        )
    ){ ExercisesDetailsScreen(navController = navController) }
}

fun NavController.navigateToExerciseDetails(id: Int){
    navigate("${ROUTE}/$id")
}