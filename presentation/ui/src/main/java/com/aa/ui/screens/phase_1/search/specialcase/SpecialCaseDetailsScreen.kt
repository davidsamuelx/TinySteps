package com.aa.ui.screens.phase_1.search.specialcase

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.ui.screens.phase_1.details.DetailsContent
import com.aa.ui.screens.phase_1.details.DetailsLoadingScreen
import com.aa.viewmodels.specialcase.SpecialCaseDetailsUiState
import com.aa.viewmodels.specialcase.SpecialCaseDetailsViewModel

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
    if(state.isLoading){

        DetailsLoadingScreen(navController = navController)

    }else{

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

}