package com.aa.ui.screens.phase_1.search.music

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
import androidx.compose.foundation.lazy.items
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
import com.aa.ui.screens.phase_1.search.composable.CustomToolbar
import com.aa.ui.screens.phase_1.search.composable.ItemCard
import com.aa.ui.screens.phase_1.search.composable.SearchBar
import com.aa.viewmodels.music.MusicUiState
import com.aa.viewmodels.music.MusicViewModel
import com.aa.viewmodels.music.MusicItemUiState

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun MusicScreen(
    navController: NavController,
    viewModel: MusicViewModel = hiltViewModel(),
){
    val state by viewModel.state.collectAsState()

    MusicContent(
        state = state,
        viewModel = viewModel,
        navController = navController,
        onClickCard = navController::navigateToMusicDetails
    )

}

@OptIn(ExperimentalFoundationApi::class)
@RequiresApi(Build.VERSION_CODES.Q)
@Composable
private fun MusicContent(
    state: MusicUiState,
    viewModel: MusicViewModel,
    onClickCard: (Int) -> Unit = {},
    navController: NavController,
){

    val colorStops = arrayOf(
        0.8f to Color(0xFFF6F9FF),
        1f to Color.Transparent
    )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF6F9FF)),

            horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Top
        ) {
            CustomToolbar(navController = navController, title = "Music")

            LazyColumn(
                contentPadding = PaddingValues(vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ){

                stickyHeader {
                    Box (
                        modifier = Modifier
                            .background(
                                Brush.verticalGradient(colorStops = colorStops)
                            )
                    ){
                        SearchBar(
                            query =  state.query,
                            onQueryChange = viewModel::onQueryChange,
                            onSearchClicked = viewModel::onMusicSearchClicked)
                    }
                }


                items(state.musicList) { item ->
                    AnimatedVisibility(
                        visible = state.query.isEmpty() || itemMatchesQuery(item, state.query),
                    ){
                    ItemCard(
                        id = item.id,
                        modifier = Modifier.padding(horizontal = 16.dp),
                        onClickItem = onClickCard, title = item.musicType, imageUrl = item.imagePath
                    )
                }
                }
            }
        }
    }


private fun itemMatchesQuery(item: MusicItemUiState, query: String): Boolean {
    return item.musicType.contains(query, ignoreCase = true)
}