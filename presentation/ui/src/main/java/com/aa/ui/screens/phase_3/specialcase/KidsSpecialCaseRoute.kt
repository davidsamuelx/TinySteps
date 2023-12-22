package com.aa.ui.screens.phase_3.specialcase

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.aa.ui.navigation.TinyStepsDestination

private const val  ROUTE = TinyStepsDestination.KidsSpecialCaseScreen

@RequiresApi(Build.VERSION_CODES.Q)
fun NavGraphBuilder.kidsSpecialCaseRoute(navController: NavController){
    composable(ROUTE){ KidsSpecialCaseScreen(navController)}
}

fun NavController.navigateToKidsSpecialCaseScreen() {
    navigate(ROUTE)
}

fun NavController.backToDiscoverScreen() {
    popBackStack()
}