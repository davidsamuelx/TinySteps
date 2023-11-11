package com.aa.ui.screens.search.specialcase

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.aa.ui.navigation.TinyStepsDestination

private const val  ROUTE = TinyStepsDestination.SpecialCaseScreen

@RequiresApi(Build.VERSION_CODES.Q)
fun NavGraphBuilder.specialCaseRoute(navController: NavController){
    composable(ROUTE){ SpecialCaseScreen(navController)}
}