package com.aa.ui.screens.phase_3.stories_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.ui.screens.phase_1.home_screen.composables.HomeHeader
import com.aa.ui.screens.phase_3.stories_screen.composables.StoriesPager
import com.aa.viewmodels.phase_3.stories_screen.StoriesUiState
import com.aa.viewmodels.phase_3.stories_screen.StoriesViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StoriesScreen(
    navController: NavController,
    viewModel: StoriesViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    if (state.storiesList.isNotEmpty()) {
        val pagerState = rememberPagerState(pageCount = { state.storiesList.size })

        StoriesContent(
            navController = navController,
            state = state,
            pagerState = pagerState,
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun StoriesContent(
    navController: NavController,
    pagerState: PagerState,
    state: StoriesUiState,
    ) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFF6F9FF))
    ){
        Column( modifier = Modifier
            .padding(bottom = 64.dp)
        ) {
            HomeHeader()

            Spacer(modifier = Modifier.height(4.dp))

            StoriesPager(pagerState = pagerState , state = state)
        }
    }

}
