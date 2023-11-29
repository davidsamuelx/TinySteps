package com.aa.ui.screens.phase_2.infants_search.sleep_hours

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.ui.screens.phase_1.details.DetailsContent
import com.aa.ui.screens.phase_1.search.composable.CustomToolbar
import com.aa.viewmodels.infants_sleep_position.InfantsSleepDetailsUiState
import com.aa.viewmodels.infants_sleep_position.InfantsSleepHoursDetailsViewModel


@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun InfantsSleepDetailsScreen (
    navController: NavController,
    viewModel: InfantsSleepHoursDetailsViewModel = hiltViewModel(),
){
    val state by viewModel.state.collectAsState()

    InfantsSleepDetailsContent(
        state = state,
        navController = navController
    )

}

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
private fun  InfantsSleepDetailsContent(
    state: InfantsSleepDetailsUiState,
    navController: NavController
){

    CustomToolbar(navController = navController, title = state.infantsSleep.doctorName!!)
    DetailsContent(
        navController = navController,
        imageUrl = state.infantsSleep.pathImg!!,
        titleName = state.infantsSleep.recommendedSleepHours!!,
        details = state.infantsSleep.details!!,
        doctorName = state.infantsSleep.doctorName!!,
        doctorLocation = state.infantsSleep.doctorLocation!!,
        doctorNumber = state.infantsSleep.phoneDoctor!!,
        problemName = "",
        problemSolve = "",
    )
}