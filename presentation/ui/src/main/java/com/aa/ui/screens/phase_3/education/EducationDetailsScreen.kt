package com.aa.ui.screens.phase_3.education

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.ui.screens.phase_1.search.composable.SongHelper
import com.aa.ui.screens.phase_3.education.composable.EducationContent
import com.aa.viewmodels.education.EducationDetailsUiState
import com.aa.viewmodels.education.EducationDetailsViewModel

@Composable
fun EducationDetailsScreen(
    viewModel: EducationDetailsViewModel = hiltViewModel(),
    navController: NavController,
    ) {
    val state by viewModel.state.collectAsState()

    DisposableEffect(Unit) {
        onDispose {
            SongHelper.releasePlayer()
        }
    }
        EducationDetailsContent(
            state = state,
            navController=navController
        )
}
@Composable
fun EducationDetailsContent(
    state:EducationDetailsUiState,
    navController: NavController,
    ){
    EducationContent(
        navController = navController,
        url =state.education.soundUrl ,
        imageUrl =state.education.imagePath,
        letter =state.education.letter
    )

}