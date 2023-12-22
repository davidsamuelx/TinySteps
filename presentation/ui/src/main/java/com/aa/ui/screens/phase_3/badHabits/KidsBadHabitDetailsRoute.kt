package com.aa.ui.screens.phase_3.badHabits

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.aa.ui.navigation.TinyStepsDestination
import com.aa.viewmodels.phase_3.badHabits.KidsBadHabitDetailsArgs

private const val  ROUTE = TinyStepsDestination.KidsBadHabitsDetailsScreen


@RequiresApi(Build.VERSION_CODES.Q)
fun NavGraphBuilder.kidsBadHabitDetailRoute(navController: NavController){
    composable(
        "$ROUTE/{${KidsBadHabitDetailsArgs.ID_ARG}}",
        arguments = listOf(
            navArgument(KidsBadHabitDetailsArgs.ID_ARG){
                type = NavType.IntType
            }
        )
    ) { KidsBadHabitDetailsScreen(navController) }
}

fun NavController.navigateToKidsBadHabitDetailRoute(id: Int){
    navigate("$ROUTE/${id}")
}


