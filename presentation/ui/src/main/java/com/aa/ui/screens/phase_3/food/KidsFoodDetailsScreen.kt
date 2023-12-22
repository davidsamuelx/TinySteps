package com.aa.ui.screens.phase_3.food

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.ui.screens.phase_1.details.DetailsContent
import com.aa.viewmodels.phase_3.kids_food.KidsFoodDetailsUiState
import com.aa.viewmodels.phase_3.kids_food.KidsFoodDetailsViewModel

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun KidsFoodDetailsScreen(
    navController: NavController,
    viewModel: KidsFoodDetailsViewModel = hiltViewModel(),
){
    val state by viewModel.state.collectAsState()

    KidsFoodDetailsContent(
       state = state,
       navController = navController
   )

}

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
private fun KidsFoodDetailsContent(
    state: KidsFoodDetailsUiState,
    navController: NavController,
){


        DetailsContent(
            navController = navController,
            imageUrl = state.food.imgFood!!,
            titleName = state.food.nameFood!!,
            details = state.food.detailsOfFood!!,
            doctorName = state.food.doctorName!!,
            doctorLocation = state.food.doctorLocation!!,
            doctorNumber = state.food.phoneDoctor!!,
            problemName = state.food.nameProblem!!,
            problemSolve = state.food.solveProblem!!,
        )
    }

