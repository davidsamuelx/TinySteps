package com.aa.ui.screens.phase_2.infants_badhabits

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.ui.screens.phase_1.details.DetailsContent
import com.aa.ui.screens.phase_1.details.DetailsLoadingScreen
import com.aa.viewmodels.infants_badhabits.InfantsBadHabitDetailsUiState
import com.aa.viewmodels.infants_badhabits.InfantsBadhabitsDetailsViewModel

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun InfantsBadHabitDetailsScreen(
    navController: NavController,
    viewModel: InfantsBadhabitsDetailsViewModel = hiltViewModel(),
){
    val state by viewModel.state.collectAsState()

    InfantsBadHabitDetailsContent(
        navController = navController,
        state = state
    )

}

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
private fun InfantsBadHabitDetailsContent(
    state: InfantsBadHabitDetailsUiState,
    navController: NavController,
){
    if (state.isLoading){
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