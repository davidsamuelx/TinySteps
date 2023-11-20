package com.aa.ui.screens.search.sleep

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.viewmodels.sleepposition.SleepPositionDetailsUiState
import com.aa.viewmodels.sleepposition.SleepPositionDetailsViewModel
import com.aa.ui.screens.details.DetailsContent

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun SleepDetailsScreen (
    navController: NavController,
    viewModel: SleepPositionDetailsViewModel = hiltViewModel(),
){
    val state by viewModel.state.collectAsState()

    SleepDetailsContent(
        state = state,
        navController = navController
    )

}

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
private fun SleepDetailsContent(
    state: SleepPositionDetailsUiState,
    navController: NavController
){
    DetailsContent(
        navController = navController,
        imageUrl = state.sleepPosition.pathImg,
        titleName = state.sleepPosition.nameOfPosition,
        details = state.sleepPosition.detailsOfPosition,
        doctorName = state.sleepPosition.doctorName,
        doctorLocation = state.sleepPosition.doctorLocation,
        doctorNumber = state.sleepPosition.phoneDoctor,
        problemName = "",
        problemSolve = "",
    )
}