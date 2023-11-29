package com.aa.ui.screens.phase_2.infants_search.products

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.aa.ui.navigation.TinyStepsDestination

private const val ROUTE = TinyStepsDestination.InfantsProductsScreen

@RequiresApi(Build.VERSION_CODES.Q)
fun NavGraphBuilder.infantsProductsRoute(navController: NavController){
    composable(ROUTE){ InfantsProductsScreen(navController = navController) }
}

fun NavController.navigateToProductsScreen() {
    navigate(ROUTE)
}
fun NavController.backToDiscoverScreen() {
    popBackStack()
}