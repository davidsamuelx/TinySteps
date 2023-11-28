package com.aa.ui.screens.phase_2.infants_badhabits

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.aa.ui.navigation.TinyStepsDestination
import com.aa.viewmodels.infants_badhabits.InfantsBadHabitDetailsArgs

private const val  ROUTE = TinyStepsDestination.InfantsBadHabitDetailScreen


@RequiresApi(Build.VERSION_CODES.Q)
fun NavGraphBuilder.infantsBadHabitDetailRoute(navController: NavController){
    composable(
        "$ROUTE/{${InfantsBadHabitDetailsArgs.ID_ARG}}",
        arguments = listOf(
            navArgument(InfantsBadHabitDetailsArgs.ID_ARG){
                type = NavType.IntType
            }
        )
    ) { InfantsBadHabitDetailsScreen(navController) }
}

fun NavController.navigateToInfantsBadHabitDetailRoute(id: Int){
    navigate("$ROUTE/${id}")
}


