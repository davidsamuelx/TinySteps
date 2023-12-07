package com.aa.ui.screens.phase_1.badhabit

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.ui.screens.phase_1.details.DetailsContent
import com.aa.ui.screens.phase_1.details.DetailsLoadingScreen
import com.aa.viewmodels.badhabit.BadHabitDetailsUiState
import com.aa.viewmodels.badhabit.BadHabitDetailsViewModel

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
    if(state.isLoading){
        DetailsLoadingScreen(navController = navController)
    }else{
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
}