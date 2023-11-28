package com.aa.ui.screens.phase_1.exercise

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aa.ui.navigation.TinyStepsDestination

private const val ROUTE = TinyStepsDestination.ExerciseScreen

@RequiresApi(Build.VERSION_CODES.Q)
fun NavGraphBuilder.exerciseRoute(navController: NavHostController){
    composable(ROUTE){ ExercisesScreen(navController = navController) }
}

fun NavController.navigateToExerciseScreen() {
    navigate(ROUTE)
}