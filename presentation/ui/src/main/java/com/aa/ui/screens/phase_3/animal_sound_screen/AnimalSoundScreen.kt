package com.aa.ui.screens.phase_3.animal_sound_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.ui.screens.phase_1.search.composable.CustomToolbar
import com.aa.ui.screens.phase_3.animal_sound_screen.composables.AnimalCards
import com.aa.ui.screens.phase_3.animal_sound_screen.composables.GamesPlayer
import com.aa.ui.screens.phase_3.animal_sound_screen.composables.GamesSongHelper
import com.aa.viewmodels.phase_3.animal_sound_screen.AnimalSoundViewModel
import com.aa.viewmodels.phase_3.animal_sound_screen.AnimalSoundsUiState

@Composable
fun AnimalSoundScreen(
    navController: NavController,
    viewModel: AnimalSoundViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    AnimalSoundContent(navController = navController, state = state, viewModel = viewModel)
}

@Composable
private fun AnimalSoundContent(
    navController: NavController,
    state: AnimalSoundsUiState,
    viewModel: AnimalSoundViewModel,
) {
    var isPlaying by remember { mutableStateOf(GamesSongHelper.isPlaying) }

    val onImageSwitch: () -> Unit = {
        GamesSongHelper.stopStream()
        isPlaying = false
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6F9FF))
    ) {
        Column(modifier = Modifier.padding(bottom = 48.dp)) {
            CustomToolbar(navController = navController, title = "")

            GamesPlayer(
                url = state.selectedSoundUrl,
                modifier = Modifier
                    .padding(top = 16.dp, start = 24.dp, end = 24.dp)
            )

            Text(
                text = "Choose the animal",
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF000000),
                ),
                modifier = Modifier
                    .padding(top = 28.dp, bottom = 28.dp)
                    .align(Alignment.CenterHorizontally)
            )
            LazyHorizontalGrid(
                modifier = Modifier
                    .wrapContentSize(),
                rows = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(horizontal = 24.dp)
            )
            {
                items(state.animalSoundsList) { item ->
                    AnimalCards(
                        id = item.id,
                        image = item.imagePath,
                        sound = item.animalSound,
                        selectedId = viewModel.selectedId,
                        onCardSelected = { id ->
                            viewModel.getAnimalSoundById(id = id)
                            onImageSwitch()
                        }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun AnimalSoundPreview() {

}