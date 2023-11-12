package com.aa.ui.screens.home_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.aa.ui.screens.details_screen.navigateToBabyDetailsScreen
import com.aa.ui.screens.home_screen.composables.BabyInfoCard
import com.aa.ui.screens.home_screen.composables.CalendarItem
import com.aa.ui.screens.home_screen.composables.HomeHeader
import com.aa.ui.screens.home_screen.composables.PregnancyProgressBar
import com.aa.viewmodels.home_screen.HomeScreenViewModel
import com.aa.viewmodels.home_screen.HomeUiState

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeScreenViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    HomeContent(
        state = state, selectedCalendarItem = state.selectedCalendarItem,
        onCalendarItemSelected = viewModel::onCalenderItemSelected,
        onDetailsCard = navController::navigateToBabyDetailsScreen
    )

}


@Composable
private fun HomeContent(
    state: HomeUiState,
    selectedCalendarItem: Int,
    onCalendarItemSelected: (Int) -> Unit,
    onDetailsCard: (Int) -> Unit
) {
    Column {
        HomeHeader()
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(12.dp)
        ) {
            item {
                Box {
                    Column {
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            contentPadding = PaddingValues(vertical = 12.dp)
                        ) {
                            items(state.calender) { index ->
                                val isClicked = index == selectedCalendarItem
                                CalendarItem(number = index, isClicked = isClicked) {
                                    onCalendarItemSelected(it-1)
                                }
                            }
                        }
                        Card(
                            modifier = Modifier
                                .size(344.dp, 368.dp)
                                .align(Alignment.CenterHorizontally)
                                .clickable {onDetailsCard(state.weekId-1)},
                        ) {
                            Image(
                                painter = rememberAsyncImagePainter(model = state.babyImage),
                                contentDescription = "babyImage",
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier.fillMaxSize(),
                            )
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        BabyInfoCard(
                            state = state,
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            onButtonClicked = { onDetailsCard(state.weekId-1) }
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        PregnancyProgressBar()

                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun HomeContentPreview() {
    var selectedCalendarItem by remember { mutableIntStateOf(1) }

    HomeContent(
        state = HomeUiState(calender = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)),
        selectedCalendarItem = selectedCalendarItem,
        onCalendarItemSelected = { selectedCalendarItem = it },
    ) {
        selectedCalendarItem = it
    }
}