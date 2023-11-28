package com.aa.ui.screens.phase_1.badhabit

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.aa.viewmodels.badhabit.BadHabitDetailsArgs
import com.aa.ui.navigation.TinyStepsDestination

private const val  ROUTE = TinyStepsDestination.BadHabitDetailScreen


@RequiresApi(Build.VERSION_CODES.Q)
fun NavGraphBuilder.badHabitDetailRoute(navController: NavController){
    composable(
        "$ROUTE/{${BadHabitDetailsArgs.ID_ARG}}",
        arguments = listOf(
            navArgument(BadHabitDetailsArgs.ID_ARG){
                type = NavType.IntType
            }
        )
    ) { BadHabitDetailsScreen(navController) }
}

fun NavController.navigateToBadHabitDetailRoute(id: Int){
    navigate("$ROUTE/${id}")
}


