package com.aa.ui.screens.phase_2.infant_exercise

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aa.ui.navigation.TinyStepsDestination

private const val ROUTE = TinyStepsDestination.InfantExerciseScreen

@RequiresApi(Build.VERSION_CODES.Q)
fun NavGraphBuilder.infantExerciseRoute(navController: NavHostController){
    composable(ROUTE){ InfantExerciseScreen(navController = navController) }
}

fun NavController.navigateToInfantExerciseScreen(){
    navigate(ROUTE)
}