package com.aa.ui.screens.phase_2.infant_exercise

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.ui.screens.composable.Loading
import com.aa.ui.screens.phase_1.search.composable.VideoPlayer
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
    if (state.isLoading){
        Loading()
    }
    val videoUrl = state.exercise.videoUrl
    if (videoUrl.isNotEmpty()) {
        VideoPlayer(url = videoUrl)
    } else {
        Log.e("VIDEO_PLAYER", "Video URL is null or empty")
    }
}