package com.aa.ui.screens.infants_badhabits

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.aa.ui.navigation.TinyStepsDestination

private const val  ROUTE = TinyStepsDestination.InfantsBadHabitScreen


fun NavController.navigateToInfantBadHabitScreen(){
    navigate(ROUTE)
}

fun NavController.backToDiscoveryScreen() {
    popBackStack()
}

@RequiresApi(Build.VERSION_CODES.Q)
fun NavGraphBuilder.infantsBadHabitRoute(navController: NavController){
    composable(ROUTE) { InfantsBadHabitScreen(navController) }
}