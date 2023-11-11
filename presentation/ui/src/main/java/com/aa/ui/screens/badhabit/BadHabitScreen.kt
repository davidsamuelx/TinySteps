package com.aa.ui.screens.badhabit

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.base.viewmodels.cateories.badhabit.BadHabitUIState
import com.aa.base.viewmodels.cateories.badhabit.BadHabitViewModel
import com.aa.ui.screens.search.composable.CustomToolbar
import com.aa.ui.screens.search.composable.ItemCard
import com.aa.ui.screens.search.composable.SearchBar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp



@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun BadHabitScreen(
    navController: NavController,
    viewModel: BadHabitViewModel = hiltViewModel(),
){

    val state by viewModel.state.collectAsState()

    BadHabitContent(
        state = state,
        navController = navController ,
        onClickCard = navController::navigateToBadHabitDetailRoute
    )

}

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
private fun BadHabitContent(
    state: BadHabitUIState,
    onClickSearch: () -> Unit = {},
    onClickCard: (Int) -> Unit = {},
    navController: NavController,
){
    val badHabitState = rememberLazyListState()

    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF6F9FF)),

            horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Top
        ) {

            CustomToolbar(navController = navController, title = "Bad Habit")

            Spacer(modifier = Modifier.height(12.dp))

            SearchBar(query =  "" , onQueryChange = {} , onSearchClicked = {})

            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                state = badHabitState,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ){
                itemsIndexed(state.badHabitsList){index, item ->
                    ItemCard(
                        id = item.id,
                        onClickItem = onClickCard,
                        title = item.nameBadHabit,
                        imageUrl = item.pathImg)
                }
            }
        }
    }
}

