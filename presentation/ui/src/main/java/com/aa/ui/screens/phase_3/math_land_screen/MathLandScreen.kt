package com.aa.ui.screens.phase_3.math_land_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.ui.screens.phase_1.search.composable.CustomToolbar
import com.aa.ui.screens.phase_3.animal_sound_screen.composables.GamesPlayer
import com.aa.ui.screens.phase_3.animal_sound_screen.composables.GamesSongHelper
import com.aa.ui.screens.phase_3.animal_sound_screen.composables.GamesSongHelper.Companion.isPlaying
import com.aa.ui.screens.phase_3.math_land_screen.composables.AnswerCard
import com.aa.ui.screens.phase_3.math_land_screen.composables.LevelDifficultyItem
import com.aa.viewmodels.phase_3.math_land_screen.MathLandUiState
import com.aa.viewmodels.phase_3.math_land_screen.MathLandViewModel

@Composable
fun MathLandScreen(
    navController: NavController,
    viewModel: MathLandViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()

    MathLandContent(
        navController = navController,
        state = state,
        viewModel = viewModel,
        selectedLevelItem = state.selectedLevel
    )
}

@Composable
private fun MathLandContent(
    navController: NavController,
    state: MathLandUiState,
    selectedLevelItem: String,
    viewModel: MathLandViewModel,
) {
    val context = LocalContext.current
    val mathLandListChanged = viewModel.mathLandListChanged.value

    val onLevelSwitch: () -> Unit = {
        GamesSongHelper.stopStream()
        isPlaying.value = false
    }

    if (viewModel.currentItemIndex < state.mathLandList.size) {
        val item = state.mathLandList[viewModel.currentItemIndex]
        val images = listOf(item.pathImg1, item.pathImg2, item.pathImg3)
        val answers = listOf("PathImg1", "PathImg2", "PathImg3")
        val isClickedList = remember { images.map { mutableStateOf(false) } }
        val isAnyCardClicked = remember { mutableStateOf(false) }

        if (mathLandListChanged) {
            isClickedList.forEach { it.value = false }
            isAnyCardClicked.value = false
            viewModel.mathLandListChanged.value = false
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF6F9FF))
        ) {
            Column(modifier = Modifier.padding(bottom = 36.dp)) {
                CustomToolbar(navController = navController, title = "")

                Text(
                    text = "Select difficulty:",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF000000),
                    ),
                    modifier = Modifier
                        .padding(top = 16.dp, start = 24.dp)
                        .align(Alignment.Start)
                )

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(vertical = 12.dp, horizontal = 24.dp)
                ) {
                    items(state.levels) { level ->
                        val isClicked = level == selectedLevelItem
                        LevelDifficultyItem(
                            level = level,
                            isClicked = isClicked,
                            onClickItem = { selectedLevel ->
                                isClickedList.forEach { it.value = false }
                                isAnyCardClicked.value = false
                                viewModel.getMathLand(selectedLevel)
                                viewModel.updateSelectedLevel(selectedLevel)
                                onLevelSwitch()
                            }
                        )
                    }
                }

                if (state.mathLandList.isNotEmpty()) {
                    GamesPlayer(
                        url = state.mathLandList.first().pathVoice,
                        modifier = Modifier.padding(
                            top = 16.dp,
                            start = 24.dp,
                            end = 24.dp,
                            bottom = 28.dp
                        )
                    )
                }

                Text(
                    text = "What does the audio say ?",
                    style = TextStyle(
                        fontSize = 18.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF000000),
                    ),
                    modifier = Modifier
                        .padding(bottom = 28.dp)
                        .align(Alignment.CenterHorizontally)
                )

                LazyColumn(
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    item {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(16.dp),
                            modifier = Modifier.padding(horizontal = 24.dp)
                        ) {
                            images.take(2).forEachIndexed { index, image ->
                                AnswerCard(
                                    correctAnswer = item.answer,
                                    images = listOf(image),
                                    answer = answers[index],
                                    isClicked = isClickedList[index].value,
                                    isAnyCardClicked = isAnyCardClicked.value,
                                    onSelectedAnswer = { selectedAnswer, isCorrect ->
                                        if (!isAnyCardClicked.value) {
                                            isClickedList[index].value = true
                                            isAnyCardClicked.value = true
                                            viewModel.updateSelectedAnswer(isCorrect)
                                        }
                                    }
                                )
                            }
                        }
                    }
                    item {
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            AnswerCard(
                                correctAnswer = item.answer,
                                images = listOf(images.last()),
                                answer = answers.last(),
                                isClicked = isClickedList.last().value,
                                isAnyCardClicked = isAnyCardClicked.value,
                                onSelectedAnswer = { selectedAnswer, isCorrect ->
                                    if (!isAnyCardClicked.value) {
                                        isClickedList.last().value = true
                                        isAnyCardClicked.value = true
                                        viewModel.updateSelectedAnswer(isCorrect)
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }

    } else {
      //  Toast.makeText(context, "sorry no more games😢", Toast.LENGTH_SHORT).show();
    }
}