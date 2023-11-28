package com.aa.ui.screens.phase_2.infant_home_screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.ui.screens.phase_1.details.DetailsContent
import com.aa.viewmodels.guidance_details.GuidanceDetailsUiState
import com.aa.viewmodels.guidance_details.GuidanceDetailsViewModel

@Composable
fun GuidanceDetailsScreen(
    navController: NavController,
    viewModel: GuidanceDetailsViewModel = hiltViewModel(),
){
    val state by viewModel.state.collectAsState()

    GuidanceDetailsContent(
        state = state,
        navController = navController
    )
}

@Composable
private fun GuidanceDetailsContent(
    state: GuidanceDetailsUiState,
    navController: NavController,
){
    DetailsContent(
        navController = navController,
        imageUrl = state.guidance.guidanceImg,
        titleName = state.guidance.guidanceTitle,
        details = state.guidance.guidanceDetails,
        doctorName = state.guidance.doctorName,
        doctorLocation = state.guidance.doctorLocation,
        doctorNumber = state.guidance.phoneDoctor,
        problemName = "",
        problemSolve = ""
    )
}