package com.aa.ui.screens.phase_3.badHabits

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.aa.ui.navigation.TinyStepsDestination

private const val  ROUTE = TinyStepsDestination.KidsBadHabitsScreen


fun NavController.navigateToKidsBadHabitScreen(){
    navigate(ROUTE)
}

fun NavController.backToDiscoveryScreen() {
    popBackStack()
}

@RequiresApi(Build.VERSION_CODES.Q)
fun NavGraphBuilder.kidsBadHabitRoute(navController: NavController){
    composable(ROUTE) { KidsBadHabitScreen(navController) }
}