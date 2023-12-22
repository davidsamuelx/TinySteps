package com.aa.ui.screens.phase_3.home_screen

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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.aa.ui.screens.phase_1.home_screen.composables.HomeHeader
import com.aa.ui.screens.phase_3.home_screen.composables.StoriesPager
import com.aa.ui.screens.phase_3.navigation_bar.NavItemKids
import com.aa.ui.screens.phase_3.navigation_bar.NavigationBarKids
import com.aa.viewmodels.phase_3.stories_screen.HomeKidsUiState
import com.aa.viewmodels.phase_3.stories_screen.HomeKidsViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun KidsHomeScreen(
    navController: NavController,
    viewModel: HomeKidsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    if (state.storiesList.isNotEmpty()) {
        val pagerState = rememberPagerState(pageCount = { state.storiesList.size })

        KidsHomeContent(
            navController = navController,
            state = state,
            pagerState = pagerState,
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun KidsHomeContent(
    navController: NavController,
    pagerState: PagerState,
    state: HomeKidsUiState,
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

        NavigationBarKids(
            navController = navController,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(12.dp),
            selectedIcon = NavItemKids.Home
        )

    }

}

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun PreviewKidsHome () {
    val pagerState = rememberPagerState(pageCount = {4})
    val navController = rememberNavController()
    KidsHomeContent(navController = navController, pagerState = pagerState, state = HomeKidsUiState() )
}
