package com.aa.ui.screens.diagnosis_screen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aa.ui.navigation.TinyStepsDestination

private const val ROUTE = TinyStepsDestination.DiagnosisScreen

fun NavController.navigateToDiagnosisScreen(){
    navigate(ROUTE)
}

fun NavController.backToDiagnosisScreen(){
    popBackStack()
}

fun NavGraphBuilder.diagnosisScreen(navController: NavHostController){
    composable(ROUTE) { DiagnosisScreen(navController = navController)}
}