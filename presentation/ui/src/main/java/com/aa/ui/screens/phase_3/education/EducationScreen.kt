package com.aa.ui.screens.phase_3.education

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.ui.R
import com.aa.ui.screens.phase_1.search.composable.CustomToolbar
import com.aa.ui.screens.phase_3.education.composable.LetterCard
import com.aa.viewmodels.education.EducationUiState
import com.aa.viewmodels.education.EducationViewModel

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun EducationScreen(
    navController: NavController,
    viewModel:EducationViewModel= hiltViewModel()
){
    val state by viewModel.state.collectAsState()
    EducationContent(
        state = state,
        navController = navController,
        onClickCard = navController::navigateToEducationDetailsScreen
    )
}
@RequiresApi(Build.VERSION_CODES.Q)
@Composable
private fun EducationContent(
    state: EducationUiState,
    onClickCard: (Int) -> Unit = {},
    navController: NavController,
){
    val easyState = rememberLazyListState()
    val mediumState = rememberLazyListState()
    val diffState = rememberLazyListState()
    val colorStops = arrayOf(
       0.8f to Color(0xFFF5F5F5),
        1f to Color(0xFFFFFFFF)
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(colorStops = colorStops)
            )
    ){
        Column( modifier = Modifier.fillMaxSize()
        ) {
            CustomToolbar(navController = navController, title = "Education")
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                item {
                Spacer(modifier = Modifier.padding(vertical = 8.dp))
                Text(
                    text = stringResource(R.string.easy),
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .wrapContentSize(),
                    style = TextStyle(
                        fontSize = 18.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF040415),
                    )
                )
                    Spacer(modifier = Modifier.padding(vertical = 4.dp))
                    LazyRow(
                    state=mediumState,
                        contentPadding = PaddingValues(start = 12.dp),

                    ){
                        itemsIndexed(state.educationList) { index, item ->

                            if (item.level == "Easy") {
                                LetterCard(
                                    id = item.id,
                                    image = item.imagePath,
                                    onClickItem ={onClickCard(item.id)}
                                )

                            }

                        }
                    }

            }
                item {
                    Spacer(modifier = Modifier.padding(vertical = 8.dp))
                    Text(
                        text = stringResource(R.string.medium),
                        modifier = Modifier
                            .padding(horizontal = 24.dp)
                            .wrapContentSize(),
                        style = TextStyle(
                            fontSize = 18.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF040415),
                        )
                    )
                    Spacer(modifier = Modifier.padding(vertical = 4.dp))
                    LazyRow(
                        state=easyState,
                        contentPadding = PaddingValues(start = 12.dp),

                    ){
                        itemsIndexed(state.educationList) { index, item ->

                            if (item.level == "Medium") {
                                LetterCard(
                                    id = item.id,
                                    image = item.imagePath,
                                    onClickItem ={onClickCard(item.id)}
                                )

                            }

                        }
                    }

                }
                item {
                    Spacer(modifier = Modifier.padding(vertical = 8.dp))
                    Text(
                        text = stringResource(R.string.hard),
                        modifier = Modifier
                            .padding(horizontal = 24.dp)
                            .wrapContentSize(),
                        style = TextStyle(
                            fontSize = 18.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF040415),
                        )
                    )
                    Spacer(modifier = Modifier.padding(vertical = 4.dp))
                    LazyRow(
                        state=diffState,
                        contentPadding = PaddingValues(start = 12.dp),

                    ){
                        itemsIndexed(state.educationList) { index, item ->

                            if (item.level == "High") {
                                LetterCard(
                                    id = item.id,
                                    image = item.imagePath,
                                    onClickItem ={onClickCard(item.id)}
                                )

                            }

                        }
                    }

                }

            }

        }

    }
}
