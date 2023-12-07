package com.aa.ui.screens.phase_2.infant_exercise

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.ui.screens.phase_1.composable.ItemLoadingScreen
import com.aa.ui.screens.phase_1.search.composable.CustomToolbar
import com.aa.ui.screens.phase_1.search.composable.ItemCard
import com.aa.ui.screens.phase_1.search.composable.SearchBar
import com.aa.viewmodels.infant_exercise.InfantExerciseUiState
import com.aa.viewmodels.infant_exercise.InfantExerciseViewModel
import com.aa.viewmodels.infant_exercise.InfantExercisesItemUiState

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun InfantExerciseScreen(
    navController: NavController,
    viewModel: InfantExerciseViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    InfantExerciseContent(
        state = state,
        viewModel = viewModel,
        navController = navController,
        onClickCard = navController::navigateToInfantExerciseDetails
    )

}

@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun InfantExerciseContent(
    state: InfantExerciseUiState,
    viewModel: InfantExerciseViewModel,
    onClickCard: (Int) -> Unit = {},
    navController: NavController,
) {
    val exerciseState = rememberLazyListState()

    val colorStops = arrayOf(
        0.8f to Color(0xFFF6F9FF),
        1f to Color.Transparent
    )

    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF6F9FF)),

            horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Top
        ) {

            CustomToolbar(navController = navController, title = "Exercise")
            if (state.isLoading) {
                ItemLoadingScreen(
                    query = state.query,
                    onQueryChange = viewModel::onQueryChange,
                    onSearchClicked = viewModel::onInfantExerciseSearchClicked
                )

            } else {
                LazyColumn(
                    contentPadding = PaddingValues(vertical = 16.dp),
                    state = exerciseState,
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    stickyHeader {
                        Box(
                            modifier = Modifier
                                .background(
                                    Brush.verticalGradient(colorStops = colorStops)
                                )
                        ) {
                            SearchBar(
                                query = state.query,
                                onQueryChange = viewModel::onQueryChange,
                                onSearchClicked = viewModel::onInfantExerciseSearchClicked
                            )
                        }
                    }

                    itemsIndexed(state.exercisesList) { index, item ->
                        AnimatedVisibility(
                            visible = state.query.isEmpty() || itemMatchesQuery(item, state.query)
                        ) {
                            ItemCard(
                                id = item.id,
                                modifier = Modifier.padding(horizontal = 16.dp),
                                onClickItem = { onClickCard(item.id) },
                                title = item.videoName,
                                imageUrl = item.imageUrl,
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun itemMatchesQuery(item: InfantExercisesItemUiState, query: String): Boolean {
    return item.videoName.contains(query, ignoreCase = true)
}