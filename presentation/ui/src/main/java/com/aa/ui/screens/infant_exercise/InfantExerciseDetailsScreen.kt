package com.aa.ui.screens.infant_exercise

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.ui.screens.search.composable.VideoPlayer
import com.aa.viewmodels.infant_exercise.InfantExerciseDetailsUiState
import com.aa.viewmodels.infant_exercise.InfantExerciseDetailsViewModel

@Composable
fun InfantExerciseDetailScreen(
    navController: NavController,
    viewModel: InfantExerciseDetailsViewModel = hiltViewModel(),
){
    val state by viewModel.state.collectAsState()

    InfantExerciseDetailContent(state = state)
    
}

@Composable
private fun InfantExerciseDetailContent(
    state: InfantExerciseDetailsUiState
){
    val videoUrl = state.exercise.videoUrl
    if (videoUrl.isNotEmpty()) {
        VideoPlayer(url = videoUrl)
    } else {
        Log.e("VIDEO_PLAYER", "Video URL is null or empty")
    }
}