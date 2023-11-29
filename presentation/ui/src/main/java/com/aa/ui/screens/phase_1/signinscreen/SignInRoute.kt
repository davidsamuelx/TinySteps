package com.aa.ui.screens.phase_1.signinscreen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aa.ui.navigation.TinyStepsDestination

private const val ROUTE = TinyStepsDestination.SignIn


fun NavController.navigateToSignInScreen() {
    navigate(ROUTE)
}

fun NavController.backToIntroScreen() {
    popBackStack()
}

fun NavGraphBuilder.signIn(navController: NavHostController) {
    composable(ROUTE) { SignInScreen(navController) }
}


