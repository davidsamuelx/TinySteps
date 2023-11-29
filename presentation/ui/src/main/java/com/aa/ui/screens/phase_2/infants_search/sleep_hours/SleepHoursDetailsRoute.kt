package com.aa.ui.screens.phase_2.infants_search.sleep_hours

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.aa.ui.navigation.TinyStepsDestination
import com.aa.viewmodels.infants_sleep_position.InfantsSleepDetailsArgs

private const val ROUTE = TinyStepsDestination.InfantsSleepDetailsScreen

@RequiresApi(Build.VERSION_CODES.Q)
fun NavGraphBuilder.infantsSleepDetailRoute(navController: NavController){
    composable(
        route = "$ROUTE/{${InfantsSleepDetailsArgs.ID_ARG}}",
        arguments = listOf(
            navArgument(InfantsSleepDetailsArgs.ID_ARG){NavType.IntType}
        )
    ){ InfantsSleepDetailsScreen(navController = navController) }
}

fun NavController.navigateToInfantsSleepDetails(id: Int){
    navigate("${ROUTE}/${id}")
}