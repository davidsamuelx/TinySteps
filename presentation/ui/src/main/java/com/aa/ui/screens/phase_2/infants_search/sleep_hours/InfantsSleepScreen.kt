package com.aa.ui.screens.phase_2.infants_search.sleep_hours

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
import com.aa.viewmodels.infants_sleep_position.InfantsSleepPositionItemUiState
import com.aa.viewmodels.infants_sleep_position.InfantsSleepUiState
import com.aa.viewmodels.infants_sleep_position.InfantsSleepViewModel


@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun InfantsSleepScreen(
    navController: NavController,
    viewModel: InfantsSleepViewModel = hiltViewModel()
){
    val state by viewModel.state.collectAsState()
    InfantsSleepContent(
        state = state,
        viewModel = viewModel,
        navController = navController,
        onClickCard = navController::navigateToInfantsSleepDetails
    )
}

@OptIn(ExperimentalFoundationApi::class)
@RequiresApi(Build.VERSION_CODES.Q)
@Composable
private fun InfantsSleepContent(
    state: InfantsSleepUiState,
    viewModel: InfantsSleepViewModel,
    onClickCard: (Int) -> Unit = {},
    navController: NavController,
){
    val sleepHoursState = rememberLazyListState()

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
            CustomToolbar(navController = navController, title = "Sleep Hours")

            if (state.isLoading){
                ItemLoadingScreen(
                    query =  state.query,
                    onQueryChange = viewModel::onQueryChange,
                    onSearchClicked = viewModel::onSleepHoursSearchClicked)

            }else{
                LazyColumn(
                    contentPadding = PaddingValues(vertical = 16.dp),
                    state = sleepHoursState,
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ){
                    stickyHeader {
                        Box (
                            modifier = Modifier
                                .background(
                                    Brush.verticalGradient(colorStops = colorStops)
                                )
                        ){
                        }
                    }
                    itemsIndexed(state.sleepHoursList) { index, item ->
                        AnimatedVisibility(
                            visible = state.query.isEmpty() || itemMatchesQuery(item, state.query),
                        ) {
                            ItemCard(
                                id = item.id!!,
                                modifier = Modifier.padding(horizontal = 16.dp),
                                onClickItem = { onClickCard(item.id!!) },
                                title = "recommended For Age : ${item.age!!}",
                                imageUrl = item.pathImg!!
                            )
                        }
                    }

                }
            }


        }
    }
}
@Composable
private fun itemMatchesQuery(item: InfantsSleepPositionItemUiState, query: String): Boolean {
    return item.age!!.contains(query, ignoreCase = true)
}