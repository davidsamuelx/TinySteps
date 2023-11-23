package com.aa.ui.screens.infant_home_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.ui.screens.home_screen.composables.HomeHeader
import com.aa.ui.screens.infant_home_screen.composables.HomePager
import com.aa.ui.screens.navigation_bar.NavItem
import com.aa.ui.screens.navigation_bar.NavigationBar
import com.aa.viewmodels.infant_home_screen.HomeInfantUiState
import com.aa.viewmodels.infant_home_screen.HomeInfantViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun InfantHomeScreen(
    navController: NavController,
    viewModel: HomeInfantViewModel = hiltViewModel()
){
    val state by viewModel.state.collectAsState()
    val pagerState = rememberPagerState(pageCount = { 3 })

    InfantHomeContent(
        navController = navController,
        state = state,
        pagerState = pagerState
    )

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun InfantHomeContent(
    navController: NavController,
    state: HomeInfantUiState,
    pagerState: PagerState,
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6F9FF))
    ){
        Column( modifier = Modifier
            .padding(bottom = 48.dp)
        ) {
            HomeHeader()

            Spacer(modifier = Modifier.padding(vertical = 8.dp))

            HomePager(state = state, pagerState = pagerState)

            Text(
                text = "Guidance",
                modifier = Modifier
                    .padding(horizontal = 24.dp),
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF040415),
                )
            )



        }
        NavigationBar(
            navController = navController,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(12.dp),
            selectedIcon = NavItem.Home
        )
    }

}