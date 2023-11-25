package com.aa.ui.screens.infants_search.sleep_hours

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.aa.ui.navigation.TinyStepsDestination

private const val ROUTE = TinyStepsDestination.InfantsSleepScreen

@RequiresApi(Build.VERSION_CODES.Q)
fun NavGraphBuilder.infantsSleepRoute(navController: NavController){
    composable(ROUTE){ InfantsSleepScreen(navController = navController) }
}

fun NavController.navigateToSleepScreen() {
    navigate(ROUTE)
}
fun NavController.backToDiscoverScreen() {
    popBackStack()
}