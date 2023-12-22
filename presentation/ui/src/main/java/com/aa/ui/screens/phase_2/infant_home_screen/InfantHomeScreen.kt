package com.aa.ui.screens.phase_2.infant_home_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
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
import com.aa.ui.screens.phase_1.home_screen.composables.HomeHeader
import com.aa.ui.screens.phase_2.infant_home_screen.composables.GuidanceCard
import com.aa.ui.screens.phase_2.infant_home_screen.composables.HomePager
import com.aa.ui.screens.phase_2.infant_home_screen.composables.RelationCard
import com.aa.ui.screens.phase_3.navigation_bar.NavItemKids
import com.aa.ui.screens.phase_2.navigation_bar.NavigationBarInfants
import com.aa.ui.screens.phase_2.relation_screen.navigateToRelationDetails
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
        pagerState = pagerState,
        onCardClick = navController::navigateToGuidanceDetails,
        onRelationClick = navController::navigateToRelationDetails
    )

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun InfantHomeContent(
    navController: NavController,
    state: HomeInfantUiState,
    pagerState: PagerState,
    onCardClick: (Int) -> Unit,
    onRelationClick: (Int) -> Unit
){
    val guidanceState = rememberLazyListState()
    val relationState = rememberLazyListState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6F9FF))
    ){
        Column( modifier = Modifier
            .padding(bottom = 64.dp)
        ) {
            HomeHeader()
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ) {
                item {
                    Spacer(modifier = Modifier.padding(vertical = 8.dp))

                    HomePager(state = state, pagerState = pagerState)

                    Spacer(modifier = Modifier.padding(vertical = 12.dp))

                    Text(
                        text = "Relation",
                        modifier = Modifier
                            .padding(horizontal = 24.dp),
                        style = TextStyle(
                            fontSize = 18.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF040415),
                        )
                    )

                    Spacer(modifier = Modifier.padding(vertical = 4.dp))

                    LazyRow(
                        contentPadding = PaddingValues(horizontal = 24.dp),
                        state = relationState,
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                    ) {
                        itemsIndexed(state.relationList) { index, item ->
                            RelationCard(
                                text = item.text,
                                title = item.title,
                                onCardClick = { onRelationClick(item.id) },
                                id = item.id
                            )
                        }
                    }

                    Spacer(modifier = Modifier.padding(vertical = 12.dp))

                    Text(
                        text = "Guidance",
                        modifier = Modifier
                            .padding(horizontal = 24.dp),
                        style = TextStyle(
                            fontSize = 18.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF040415),
                        )
                    )
                    Spacer(modifier = Modifier.padding(vertical = 4.dp))

                    LazyRow(
                        contentPadding = PaddingValues(horizontal = 24.dp),
                        state = guidanceState,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        itemsIndexed(state.guidanceList) { index, item ->
                            GuidanceCard(
                                image = item.image,
                                text = item.guidanceTitle,
                                onCardClick = { onCardClick(item.id) },
                                id = item.id
                            )
                        }
                    }


                }
            }

        }
        NavigationBarInfants(
            navController = navController,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(12.dp),
            selectedIcon = NavItemKids.Home
        )

    }

}