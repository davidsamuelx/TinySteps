package com.aa.ui.screens.phase_1.search.sleep

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.aa.viewmodels.sleepposition.SleepDetailsArgs
import com.aa.ui.navigation.TinyStepsDestination

private const val ROUTE = TinyStepsDestination.SleepPositionByIdDetailsScreen

@RequiresApi(Build.VERSION_CODES.Q)
fun NavGraphBuilder.sleepDetailRoute(navController: NavController){
    composable(
        route = "$ROUTE/{${SleepDetailsArgs.ID_ARG}}",
        arguments = listOf(
            navArgument(SleepDetailsArgs.ID_ARG){NavType.IntType}
        )
    ){ SleepDetailsScreen(navController = navController) }
}

fun NavController.navigateToSleepDetails(id: Int){
    navigate("${ROUTE}/${id}")
}