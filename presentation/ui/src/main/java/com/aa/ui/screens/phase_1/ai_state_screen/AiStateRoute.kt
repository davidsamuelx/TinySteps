package com.aa.ui.screens.phase_1.ai_state_screen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aa.ui.navigation.TinyStepsDestination

private const val ROUTE = TinyStepsDestination.AiStateScreen


fun NavController.navigateToAiStateScreen() {
    navigate(ROUTE)
}

fun NavController.backToAiStateScreen() {
    popBackStack()
}

fun NavGraphBuilder.aiStateScreen(navController: NavHostController) {
    composable(ROUTE) { AiStateScreen(navController) }
}