package com.aa.ui.screens.phase_3.difference_game

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.aa.ui.navigation.TinyStepsDestination

private const val ROUTE = TinyStepsDestination.DiffOfImageScreen

@RequiresApi(Build.VERSION_CODES.Q)
fun NavGraphBuilder.diffOfTwoImage(navController: NavController){
    composable(ROUTE){ DifferenceOfImageScreen(navController = navController) }
}

fun NavController.navigateToDiffOfImageScreen() {
    navigate(ROUTE)
}