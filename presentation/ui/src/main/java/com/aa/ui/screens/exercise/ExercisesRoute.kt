package com.aa.ui.screens.exercise

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.aa.ui.navigation.TinyStepsDestination

private const val ROUTE = TinyStepsDestination.ExerciseScreen

@RequiresApi(Build.VERSION_CODES.Q)
fun NavGraphBuilder.exerciseRoute(navController: NavController){
    composable(ROUTE){ ExercisesScreen(navController = navController) }
}

fun NavController.navigateToExerciseScreen() {
    navigate(ROUTE)
}