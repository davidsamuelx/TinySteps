package com.aa.ui.screens.phase_3.difference_game

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.ui.screens.phase_3.composable.ImageCard
import com.aa.ui.screens.phase_3.difference_game.composable.AnswerCard
import com.aa.viewmodels.diff_images.DiffOfTwoImageViewModel
import com.aa.viewmodels.diff_images.DiffOfTwoImagesUiState
@Composable
fun DifferenceOfImage(
    viewModel: DiffOfTwoImageViewModel = hiltViewModel(),
    navController: NavController
) {
    val state by viewModel.state.collectAsState()
    DifferenceOfImageContent(
        state = state,
        viewModel=viewModel,
        navController = navController
        )
}

@Composable
private fun DifferenceOfImageContent(
    state: DiffOfTwoImagesUiState,
    viewModel: DiffOfTwoImageViewModel,
    navController: NavController
) {
    val context = LocalContext.current
    val diffOfImageListChanged = viewModel.diffOfImageChanged.value
    if (viewModel.currentItemIndex < state.diffOfTwoImage.size) {
        val item = state.diffOfTwoImage[viewModel.currentItemIndex]
        val chooses = listOf(
            item.chooseOne.toString(),
            item.chooseTwo.toString(),
            item.chooseThree.toString(),
            item.chooseFour.toString()
        )
        val answers = listOf("chooseOne", "chooseTwo", "chooseThree", "chooseFour")
        val isClickedList = remember { chooses.map { mutableStateOf(false) } }
        val isAnyCardClicked = remember { mutableStateOf(false) }

        if (diffOfImageListChanged) {
            isClickedList.forEach { it.value = false }
            isAnyCardClicked.value = false
            viewModel.diffOfImageChanged.value = false
        }
        Surface {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFF6F9FF)),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {
                if (state.diffOfTwoImage.isNotEmpty()) {
                    ImageCard(
                        image1 = "state.diffOfTwoImage.first().pathImgOne",
                        image2 = state.diffOfTwoImage.first().pathImgTwo
                    )
                }
                    LazyColumn(
                        modifier = Modifier
                            .padding(horizontal = 32.dp)
                    ) {
                        item {
                            chooses.take(4).forEachIndexed { index, image ->
                                AnswerCard(
                                    correctAnswer = item.howManyDiff.toString(),
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

                }
            }
        } else {
        //  Toast.makeText(context, "sorry no more games😢", Toast.LENGTH_SHORT).show();
    }
    }


