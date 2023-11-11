package com.aa.ui.screens.search.food

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.aa.ui.navigation.TinyStepsDestination

private const val ROUTE = TinyStepsDestination.FoodScreen

@RequiresApi(Build.VERSION_CODES.Q)
fun NavGraphBuilder.foodRoute(navController: NavController){
    composable(ROUTE){ FoodScreen(navController = navController) }
}