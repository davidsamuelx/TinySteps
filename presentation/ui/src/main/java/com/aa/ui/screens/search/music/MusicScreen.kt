package com.aa.ui.screens.search.music

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
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.base.viewmodels.cateories.music.MusicUiState
import com.aa.base.viewmodels.cateories.music.MusicViewModel
import com.aa.ui.screens.search.composable.CustomToolbar
import com.aa.ui.screens.search.composable.ItemCard
import com.aa.ui.screens.search.composable.SearchBar

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun MusicScreen(
    navController: NavController,
    viewModel: MusicViewModel = hiltViewModel(),
){
    val state by viewModel.state.collectAsState()

    MusicContent(
        state = state,
        navController = navController,
    )

}

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
private fun MusicContent(
    state: MusicUiState,
    onClickSearch: () -> Unit = {},
    onClickCard: () -> Unit = {},
    navController: NavController,
){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF6F9FF)),

            horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Top
        ) {
            CustomToolbar(navController = navController, title = "Music")


            Spacer(modifier = Modifier.height(12.dp))

            SearchBar(query =  "" , onQueryChange = {} , onSearchClicked = {})

            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ){
                items(state.musicList){ item ->
                    println(item.id)
                    ItemCard(
                        id = item.id,
                        onClickItem = {}
                        , title = item.musicType
                        , imageUrl = item.imagePath
                    )
                }
            }
        }
    }