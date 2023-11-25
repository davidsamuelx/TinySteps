package com.aa.ui.screens.infants_search.food

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.aa.ui.navigation.TinyStepsDestination

private const val ROUTE = TinyStepsDestination.InfantFoodScreen

@RequiresApi(Build.VERSION_CODES.Q)
fun NavGraphBuilder.infantsFoodRoute(navController: NavController){
    composable(ROUTE){ InfantsFoodScreen(navController = navController) }
}

fun NavController.navigateToFoodScreen() {
    navigate(ROUTE)
}
fun NavController.backToDiscoverScreen() {
    popBackStack()
}