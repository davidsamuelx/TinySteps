package com.aa.ui.screens.badhabit

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.aa.ui.navigation.TinyStepsDestination

private const val  ROUTE = TinyStepsDestination.BadHabitScreen


fun NavController.navigateToBadHabitScreen(){
    navigate(ROUTE)
}

fun NavController.backToDiscoveryScreen() {
    popBackStack()
}

@RequiresApi(Build.VERSION_CODES.Q)
fun NavGraphBuilder.badHabitRoute(navController: NavController){
    composable(ROUTE) { BadHabitScreen(navController) }
}