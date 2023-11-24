package com.aa.ui.screen.signUp

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aa.ui.navigation.TinyStepsDestination

private const val ROUTE = TinyStepsDestination.SignUp


fun NavController.navigateToSignUpScreen() {
    navigate(ROUTE)
}

fun NavController.backToSignInScreen() {
    popBackStack()
}

fun NavGraphBuilder.signUp(navController: NavHostController) {
    composable(ROUTE) { SignUpScreen(navController) }
}


