package com.aa.ui.screens.phase_3.badHabits

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.ui.screens.phase_1.details.DetailsContent
import com.aa.viewmodels.phase_3.badHabits.KidsBadHabitDetailsUiState
import com.aa.viewmodels.phase_3.badHabits.KidsBadhabitsDetailsViewModel

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun KidsBadHabitDetailsScreen(
    navController: NavController,
    viewModel: KidsBadhabitsDetailsViewModel = hiltViewModel(),
){
    val state by viewModel.state.collectAsState()

    KidsBadHabitDetailsContent(
        navController = navController,
        state = state
    )

}

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
private fun KidsBadHabitDetailsContent(
    state: KidsBadHabitDetailsUiState,
    navController: NavController,
){

        DetailsContent(
            navController = navController,
            imageUrl = state.badHabit.pathImg,
            titleName = state.badHabit.nameBadHabit,
            details = state.badHabit.details,
            doctorName = state.badHabit.doctorName,
            doctorLocation = state.badHabit.doctorLocation,
            doctorNumber = state.badHabit.phoneDoctor,
            problemName = state.badHabit.nameBadHabit,
            problemSolve = state.badHabit.solveProblem,
        )

}