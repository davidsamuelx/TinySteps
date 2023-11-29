package com.aa.ui.screens.phase_2.infants_search.infants_specialcase

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.aa.ui.navigation.TinyStepsDestination

private const val  ROUTE = TinyStepsDestination.InfantsSpecialCaseScreen

@RequiresApi(Build.VERSION_CODES.Q)
fun NavGraphBuilder.infantsSpecialCaseRoute(navController: NavController){
    composable(ROUTE){ InfantsSpecialCaseScreen(navController)}
}

fun NavController.navigateToInfantsSpecialCaseScreen() {
    navigate(ROUTE)
}

fun NavController.backToDiscoverScreen() {
    popBackStack()
}