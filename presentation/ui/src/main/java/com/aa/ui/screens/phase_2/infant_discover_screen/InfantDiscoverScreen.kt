package com.aa.ui.screens.phase_2.infant_discover_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import com.aa.ui.screens.phase_1.discover_screen.composable.DiscoverCard
import com.aa.ui.screens.phase_2.navigation_bar.NavItemInfants
import com.aa.ui.screens.phase_2.navigation_bar.NavigationBarInfants
import com.aa.viewmodels.infant_discover.InfantDiscoverUiState
import com.aa.viewmodels.infant_discover.InfantDiscoverViewModel

@Composable
fun InfantDiscoverScreen(
    navController: NavController,
    viewModel: InfantDiscoverViewModel =  hiltViewModel(),
    ){
    val state by viewModel.state.collectAsState()
    InfantDiscoverContent(state = state, navController = navController)

}

@Composable
private fun InfantDiscoverContent(
    state: InfantDiscoverUiState,
    navController: NavController,
){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        Text(
            text = "Discover",
            style = TextStyle(
                fontSize = 24.sp,
                lineHeight = 32.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF040415),
            ),
            modifier = Modifier.padding(start = 16.dp, bottom = 8.dp, top = 16.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp,top = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(state.discoverList) { item ->
                DiscoverCard(
                    icon = item.icon,
                    text = item.text,
                    color = item.color,
                    navController = navController,
                    destination = item.destination
                )
            }
        }

        NavigationBarInfants(navController = navController,modifier = Modifier.padding(12.dp), selectedIcon = NavItemInfants.Discover)
    }
}