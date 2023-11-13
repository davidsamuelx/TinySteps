package com.aa.ui.screens.search.music

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.viewmodels.music.MusicDetailsUiState
import com.aa.viewmodels.music.MusicDetailsViewModel
import com.aa.ui.screens.search.composable.MusicPlayer
import com.aa.ui.screens.search.composable.SongHelper

@Composable
fun MusicDetailsScreen(
    navController: NavController,
    viewModel: MusicDetailsViewModel = hiltViewModel(),
){
    val state by viewModel.state.collectAsState()

    DisposableEffect(Unit) {
        onDispose {
            SongHelper.releasePlayer()
        }
    }

    MusicDetailsContent(
        state = state
    )

}


@Composable
private fun MusicDetailsContent(
    state: MusicDetailsUiState
){
    MusicPlayer(
        url = state.music.musicUrl,
        imageUrl = state.music.imagePath,
        songName = state.music.musicType
    )
}