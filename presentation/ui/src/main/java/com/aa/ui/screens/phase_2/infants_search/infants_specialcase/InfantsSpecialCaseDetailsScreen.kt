package com.aa.ui.screens.phase_2.infants_search.infants_specialcase

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.ui.screens.phase_1.details.DetailsContent
import com.aa.ui.screens.phase_1.details.DetailsLoadingScreen
import com.aa.viewmodels.infants_specialcase.InfantsSpecialCaseDetailsUiState
import com.aa.viewmodels.infants_specialcase.InfantsSpecialCaseDetailsViewModel


@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun InfantsSpecialCaseDetailsScreen(
    navController: NavController,
    viewModel: InfantsSpecialCaseDetailsViewModel = hiltViewModel(),
){
    val state by viewModel.state.collectAsState()

    SpecialCaseDetailsContent(
        state = state,
        navController = navController
    )

}

@Composable
private fun SpecialCaseDetailsContent(
    state: InfantsSpecialCaseDetailsUiState,
    navController: NavController,
){
    if (state.isLoading){

        DetailsLoadingScreen(navController = navController)

    }else{

        DetailsContent(
            navController = navController,
            imageUrl = state.specialCase.pathImg!!,
            titleName = state.specialCase.nameSpecialCase!!,
            details = state.specialCase.details!!,
            doctorName = state.specialCase.doctorName!!,
            doctorLocation = state.specialCase.doctorLocation!!,
            doctorNumber = state.specialCase.phoneDoctor!!,
            problemName = state.specialCase.nameSpecialCase!!,
            problemSolve = state.specialCase.solveProblem!!,
        )
    }

}