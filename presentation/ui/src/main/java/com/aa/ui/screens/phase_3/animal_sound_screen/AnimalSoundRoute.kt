package com.aa.ui.screens.phase_3.animal_sound_screen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.aa.ui.navigation.TinyStepsDestination

private const val ROUTE = TinyStepsDestination.AnimalSoundScreen

fun NavController.navigateToAnimalSoundScreen() {
    navigate(ROUTE)
}

fun NavGraphBuilder.animalSoundScreen(navController: NavController){
    composable(ROUTE){ AnimalSoundScreen(navController = navController) }
}
