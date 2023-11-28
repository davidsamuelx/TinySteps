package com.aa.ui.screens.phase_2.relation_screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.ui.screens.phase_2.relation_screen.composable.RelationDetails
import com.aa.viewmodels.relation_details.RelationDetailsUiState
import com.aa.viewmodels.relation_details.RelationDetailsViewModel

@Composable
fun RelationDetailsScreen(
    navController: NavController,
    viewModel: RelationDetailsViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()

    RelationDetailsContent(
        navController = navController,
        state = state
    )
}

@Composable
fun RelationDetailsContent(
    navController: NavController,
    state: RelationDetailsUiState
    ) {
    RelationDetails(
        navController = navController,
        titleName = state.relation.relationTitle,
        details = state.relation.relationDetails,
        doctorName = state.relation.doctorName,
        doctorLocation = state.relation.doctorLocation,
        doctorNumber = state.relation.phoneDoctor
    )
}