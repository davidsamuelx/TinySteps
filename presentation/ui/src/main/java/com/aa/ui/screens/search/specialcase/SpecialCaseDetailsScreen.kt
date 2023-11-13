package com.aa.ui.screens.search.specialcase

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.viewmodels.specialcase.SpecialCaseDetailsUiState
import com.aa.viewmodels.specialcase.SpecialCaseDetailsViewModel
import com.aa.ui.screens.details.DetailsContent

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun SpecialCaseDetailsScreen(
    navController: NavController,
    viewModel: SpecialCaseDetailsViewModel = hiltViewModel(),
){
    val state by viewModel.state.collectAsState()

    SpecialCaseDetailsContent(
        state = state,
        navController = navController
    )

}

@Composable
private fun SpecialCaseDetailsContent(
    state: SpecialCaseDetailsUiState,
    navController: NavController,
){
    DetailsContent(
        navController = navController,
        imageUrl = state.specialCase.pathImg,
        titleName = state.specialCase.nameSpecialCase,
        details = state.specialCase.details,
        doctorName = state.specialCase.doctorName,
        doctorLocation = state.specialCase.doctorLocation,
        doctorNumber = state.specialCase.phoneDoctor,
        problemName = state.specialCase.nameSpecialCase,
        problemSolve = state.specialCase.solveProblem,
    )
}