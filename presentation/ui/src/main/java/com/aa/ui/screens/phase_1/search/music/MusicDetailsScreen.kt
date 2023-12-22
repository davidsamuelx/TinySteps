package com.aa.ui.screens.phase_1.search.music

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.ui.screens.phase_1.search.composable.MusicPlayer
import com.aa.ui.screens.phase_1.search.composable.SongHelper
import com.aa.viewmodels.music.MusicDetailsUiState
import com.aa.viewmodels.music.MusicDetailsViewModel

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
    val musicUrl = state.music.musicUrl
    if (musicUrl.isNotEmpty()) {
        MusicPlayer(
            url = state.music.musicUrl,
            imageUrl = state.music.imagePath,
            songName = state.music.musicType
        )
    }else{
        Log.e("MUSIC_PLAYER", "Music URL is null or empty")
    }
}