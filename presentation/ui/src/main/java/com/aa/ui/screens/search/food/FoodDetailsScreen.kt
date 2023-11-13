package com.aa.ui.screens.search.food

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.base.viewmodels.cateories.food.FoodDetailsUiState
import com.aa.base.viewmodels.cateories.food.FoodDetailsViewModel
import com.aa.ui.screens.details.DetailsContent

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun FoodDetailsScreen(
    navController: NavController,
    viewModel: FoodDetailsViewModel = hiltViewModel(),
){
    val state by viewModel.state.collectAsState()

   FoodDetailsContent(
       state = state,
       navController = navController
   )

}

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
private fun FoodDetailsContent(
    state: FoodDetailsUiState,
    navController: NavController,
){
    DetailsContent(
        navController = navController,
        imageUrl = state.food.imgFood,
        titleName = state.food.nameFood,
        details = state.food.detailsOfFood,
        doctorName = state.food.doctorName,
        doctorLocation = state.food.doctorLocation,
        doctorNumber = state.food.phoneDoctor,
        problemName = state.food.nameProblem,
        problemSolve = state.food.solveProblem,
    )
}