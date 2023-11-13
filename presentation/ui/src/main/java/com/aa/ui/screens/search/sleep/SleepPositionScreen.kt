package com.aa.ui.screens.search.sleep

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.base.viewmodels.cateories.sleepposition.SleepPositionUiState
import com.aa.base.viewmodels.cateories.sleepposition.SleepPositionViewModel
import com.aa.ui.screens.search.composable.CustomToolbar
import com.aa.ui.screens.search.composable.ItemCard
import com.aa.ui.screens.search.composable.SearchBar

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun SleepPositionScreen(
    navController: NavController,
    viewModel: SleepPositionViewModel = hiltViewModel(),
){
    val state by viewModel.state.collectAsState()

    SleepPositionContent(
        state = state,
        navController = navController,
        onClickCard = navController::navigateToSleepDetails
    )

}

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
private fun SleepPositionContent(
    state: SleepPositionUiState,
    onClickSearch: () -> Unit = {},
    onClickCard: (Int) -> Unit = {},
    navController: NavController,
){
    val sleepPositionState = rememberLazyListState()

    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF6F9FF)),

            horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Top
        ) {

            CustomToolbar(navController = navController, title = "Sleep Position")

            Spacer(modifier = Modifier.height(12.dp))

            SearchBar(query =  "" , onQueryChange = {} , onSearchClicked = {})

            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                state = sleepPositionState,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ){
                itemsIndexed(state.sleepPositionList){index, item ->
                    ItemCard(
                        id = item.id,
                        onClickItem = { onClickCard(item.id) },
                        title = item.nameOfPosition,
                        imageUrl = item.pathImg)
                }
            }
        }
    }
}