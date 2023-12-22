package com.aa.ui.screens.phase_3.stories_screen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.aa.ui.navigation.TinyStepsDestination

private const val ROUTE = TinyStepsDestination.StoriesScreen

fun NavController.navigateToStoriesScreen() {
    navigate(ROUTE)
}

fun NavController.backToStoriesScreen() {
    popBackStack()
}

fun NavGraphBuilder.storiesRoute(navController: NavController){
    composable(ROUTE){ StoriesScreen(navController = navController) }
}