package com.aa.ui.screens.phase_3.difference_game

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.ui.R
import com.aa.ui.screens.phase_1.composable.VerticalSpacer
import com.aa.ui.screens.phase_1.navigation_bar.NavigationBar
import com.aa.ui.screens.phase_1.search.composable.CustomToolbar
import com.aa.ui.screens.phase_3.composable.ImageCard
import com.aa.ui.screens.phase_3.difference_game.composable.ChoiceBox
import com.aa.viewmodels.diff_images.DiffOfTwoImageViewModel
import com.aa.viewmodels.diff_images.DiffOfTwoImagesUiState
@Composable
fun DifferenceOfImageScreen(
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
    val diffOfImageListChanged = viewModel.diffOfImageChanged.value
    if (viewModel.currentItemIndex < state.diffOfTwoImage.size) {
        val item = state.diffOfTwoImage[viewModel.currentItemIndex]
        val chooses = listOf(
            item.chooseOne,
            item.chooseTwo,
            item.chooseThree,
            item.chooseFour
        )
        val isClickedList = remember { chooses.map { mutableStateOf(false) } }
        val isAnyCardClicked = remember { mutableStateOf(false) }

        if (diffOfImageListChanged) {
            isClickedList.forEach { it.value = false }
            isAnyCardClicked.value = false
            viewModel.diffOfImageChanged.value = false
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF6F9FF))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFF6F9FF)),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {
                CustomToolbar(navController = navController, title ="" )
                if (state.diffOfTwoImage.isNotEmpty())  {
                        ImageCard(
                            image1 =item.pathImgOne ,
                            image2 = item.pathImgTwo)
                    Text(
                        text = stringResource(R.string.how_many_differences),
                        style = TextStyle(
                            fontSize = 18.sp,
                            lineHeight = 24.sp,
                            fontWeight = FontWeight(500),
                            color = Color.Black,

                        ),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(horizontal = 16.dp, vertical = 16.dp)
                    )
                    VerticalSpacer(space = 8.dp)

                    LazyColumn(
                        modifier = Modifier
                            .padding(horizontal = 32.dp)
                    ) {
                        item {
                            chooses.take(4).forEachIndexed { index, choice ->
                                ChoiceBox(
                                    correctAnswer = item.howManyDiff,
                                    choices = listOf(choice),
                                    answer =chooses[index],
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
                                VerticalSpacer(space = 8.dp)
                            }
                        }

                    }
                }

            }
                NavigationBar(
                    navController = navController,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(12.dp),
                )

        }
        }

    }


