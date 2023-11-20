package com.aa.ui.screens.search.sleep

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.aa.ui.navigation.TinyStepsDestination

private const val ROUTE = TinyStepsDestination.SleepScreen

@RequiresApi(Build.VERSION_CODES.Q)
fun NavGraphBuilder.sleepPositionRoute(navController: NavController){
    composable(ROUTE){ SleepPositionScreen(navController = navController) }
}

fun NavController.navigateToSleepScreen() {
    navigate(ROUTE)
}
