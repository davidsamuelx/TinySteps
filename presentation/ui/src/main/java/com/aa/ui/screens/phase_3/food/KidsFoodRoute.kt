package com.aa.ui.screens.phase_3.food

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.aa.ui.navigation.TinyStepsDestination

private const val ROUTE = TinyStepsDestination.KidsFoodScreen

@RequiresApi(Build.VERSION_CODES.Q)
fun NavGraphBuilder.kidsFoodRoute(navController: NavController){
    composable(ROUTE){ KidsFoodScreen(navController = navController) }
}

fun NavController.navigateToFoodScreen() {
    navigate(ROUTE)
}
fun NavController.backToDiscoverScreen() {
    popBackStack()
}