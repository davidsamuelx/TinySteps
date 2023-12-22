package com.aa.ui.screens.phase_3.education

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.aa.ui.navigation.TinyStepsDestination


private const val ROUTE = TinyStepsDestination.EducationScreen

@RequiresApi(Build.VERSION_CODES.Q)
fun NavGraphBuilder.educationRoute(navController: NavController){
    composable(ROUTE){ EducationScreen(navController = navController) }
}

fun NavController.navigateToEducationScreen() {
    navigate(ROUTE)
}