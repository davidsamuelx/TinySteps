package com.aa.ui.screens.exercise

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.base.viewmodels.cateories.exercise.ExerciseDetailsUiState
import com.aa.base.viewmodels.cateories.exercise.ExerciseDetailsViewModel
import com.aa.ui.screens.search.composable.VideoPlayer

@Composable
fun ExercisesDetailsScreen(
    navController: NavController,
    viewModel: ExerciseDetailsViewModel = hiltViewModel(),
){
    val state by viewModel.state.collectAsState()

    ExercisesDetailsContent(
        state = state
    )

}

@Composable
private fun ExercisesDetailsContent(
    state: ExerciseDetailsUiState
){
    VideoPlayer(url = state.exercise.videoUrl)
}