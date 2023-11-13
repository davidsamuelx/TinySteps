package com.aa.ui.screens.badhabit

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.base.viewmodels.cateories.badhabit.BadHabitDetailsUiState
import com.aa.base.viewmodels.cateories.badhabit.BadHabitDetailsViewModel
import com.aa.ui.screens.details.DetailsContent

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun BadHabitDetailsScreen(
    navController: NavController,
    viewModel: BadHabitDetailsViewModel = hiltViewModel(),
){
    val state by viewModel.state.collectAsState()

    BadHabitDetailsContent(
        navController = navController,
        state = state
    )

}

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
private fun BadHabitDetailsContent(
    state: BadHabitDetailsUiState,
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